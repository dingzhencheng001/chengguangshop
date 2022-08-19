package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.entity.AppControl;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.mapper.AppAssignGoodsMapper;
import my.fast.admin.cg.mapper.AppControlMapper;
import my.fast.admin.cg.mapper.AppConveyMapper;
import my.fast.admin.cg.mapper.AppGoodsMapper;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberAddressMapper;
import my.fast.admin.cg.mapper.AppMemberLevelMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.model.AppMemberBalanceParam;
import my.fast.admin.cg.model.AppRandomOrderParam;
import my.fast.admin.cg.service.AppGrabOrdersService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 15:08
 */
@Service
public class AppGrabOrdersServiceImpl implements AppGrabOrdersService {

    @Autowired
    private AppGoodsMapper appGoodsMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Autowired
    private AppMemberLevelMapper appMemberLevelMapper;

    @Autowired
    private AppConveyMapper appConveyMapper;

    @Autowired
    private AppMemberAddressMapper appMemberAddressMapper;

    @Autowired
    private AppAssignGoodsMapper appAssignGoodsMapper;

    @Autowired
    private AppControlMapper controlMapper;

    @Override
    public Object randomOrders(AppRandomOrderParam appRandomOrderParam) throws Exception {
        Long memberId = appRandomOrderParam.getMemberId();
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        if (StringUtils.isEmpty(appMember)) {
            throw new Exception("824");
        }
        AppMemberLevel appMemberLevel = appMemberLevelMapper.selectByPrimaryKey(appMember.getMemberLevelId());
        List<AppConvey> appConveys = appConveyMapper.selectConvey();
        if (appConveys != null && appConveys.size() > 0) {
            Integer orderLimitNum = appMemberLevel.getOrderNum();
            Long qiang = appConveys.stream()
                .map(e -> e.getQiang())
                .reduce(Long::max)
                .get();
            String num = String.valueOf(qiang);
            int userOderNum = Integer.parseInt(num);
            if (userOderNum == orderLimitNum) {
                throw new Exception("825");
            }
        }
        return getObject(appRandomOrderParam, appMember);
    }

    public Object getObject(AppRandomOrderParam appRandomOrderParam, AppMember appMember) throws Exception {
        List<AppAssignGoods> assignGoodsList = appAssignGoodsMapper.assignGoodsList(appRandomOrderParam);
        if (assignGoodsList != null && assignGoodsList.size() > 0) {
            AppAssignGoods appAssignGoods = assignGoodsList.get(0);
            appAssignGoods.setGoodsAddTime(DateFormat.getNowDate());
            BigDecimal goodsPrice = appAssignGoods.getGoodsPrice();
            BigDecimal balance = appMember.getBalance();
            BigDecimal disposalAmount = balance.subtract(appMember.getFreezeBalance());
            int flag = goodsPrice.compareTo(disposalAmount);
            if (flag >= 0) {
                throw new Exception("832");
            }
            return appAssignGoods;
        } else {
            //商品表直接随机生成返回用户
            return randomGoods(appMember);
        }
    }

    //随机生成订单
    public Object randomGoods(AppMember appMember) throws Exception {
        AppGoods appGoods = new AppGoods();
        if (!StringUtils.isEmpty(appMember)) {
            BigDecimal balance = appMember.getBalance();
            //先写死,后续从规则里面获取
            BigDecimal rate = new BigDecimal("0.5");
            BigDecimal useBalance = balance.multiply(rate);
            appGoods = appGoodsMapper.randomOrders(useBalance);
            appGoods.setGoodsAddTime(DateFormat.getNowDate());
            BigDecimal goodsPrice = appGoods.getGoodsPrice();
            BigDecimal disposalAmount = balance.subtract(appMember.getFreezeBalance());
            int flag = goodsPrice.compareTo(disposalAmount);
            if (flag >= 0) {
                throw new Exception("832");
            }
        }
        return appGoods;
    }

    @Override
    public int submitOrders(Object goods, Long memberId, Long channelId) throws Exception {
        //判断商品类型
        JSONObject json = (JSONObject) JSON.toJSON(goods);
        boolean goodsFlag = json.containsKey("goodsFlag");
        if (goodsFlag) {
            //指派订单
            AppAssignGoods appAssignGoods = JSON.parseObject(JSON.toJSONString(goods), AppAssignGoods.class);
            //生成订单号
            String orderSn = appAssignGoods.getSerialNumber();
            return submitDistributionGoods(appAssignGoods, memberId, channelId, orderSn);
        } else {
            //传统订单
            AppGoods appGoods = JSON.parseObject(JSON.toJSONString(goods), AppGoods.class);
            //生成订单号
            String orderSn = generateOrderSn();
            return submitTraditionOrders(appGoods, memberId, channelId, orderSn);
        }
    }

    //传统订单
    private int submitTraditionOrders(AppGoods appGoods, Long memberId, Long channelId, String orderSn)
    throws Exception {
        AppConvey appConvey = new AppConvey();
        //获取会员信息
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        BigDecimal goodsPrice = appGoods.getGoodsPrice();
        //获取会员等级
        AppMemberLevel appMemberLevel = appMemberLevelMapper.selectByPrimaryKey(appMember.getMemberLevelId());
        BigDecimal commission = appMemberLevel.getCommission();
        //获取上下级代理佣金比例
        AppControl appControl = controlMapper.selectByChannelId(channelId);
        //佣金计算
        BigDecimal GrabCommission = goodsPrice.multiply(commission);
        appConvey.setCommission(GrabCommission);
        //设置商品订单id
        appConvey.setGoodsId(appGoods.getId());
        //设置渠道id
        appConvey.setChannelId(channelId);
        //设置会员id
        appConvey.setMemberId(appMember.getId());
        //生成订单号
        appConvey.setLno(orderSn);
        //设置本单金额
        appConvey.setAmount(appGoods.getGoodsPrice());
        //设置下单时间
        appConvey.setAddtime(DateFormat.getNowDate());
        //设置完成时间
        appConvey.setEndtime(DateFormat.getNowDate());
        //设置订单状态
        appConvey.setStatus("1");
        //设置佣金发放状态
        appConvey.setcStatus("1");
        //设置卡不卡单
        appConvey.setSign("0");
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("826");
        }
        //设置抢单数
        List<AppConvey> appConveys = appConveyMapper.selectConvey();
        if (null == appConveys || appConveys.size() == 0) {
            appConvey.setQiang(1L);
        } else {
            Long qiang = appConveys.stream()
                .map(e -> e.getQiang())
                .reduce(Long::max)
                .get();
            appConvey.setQiang(qiang + 1);
        }
        //修改会员余额金额
        AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
        appMemberBalanceParam.setMemberId(memberId);
        appMemberBalanceParam.setGoodsPrice(goodsPrice);
        appMemberBalanceParam.setBalance(appMember.getBalance());
        appMemberBalanceParam.setGrabCommission(GrabCommission);
        appMemberBalanceParam.setChannelId(channelId);
        appMemberMapper.updateMemberBalance(appMemberBalanceParam);
        //查询parentAgent
        appMemberMapper.selectParent();
        List<AppMember> appMembers = appMemberMapper.selectAppMemberParentAgent(memberId);
        //更新parentAgentBalance
        calculateCommission(appMembers, goodsPrice, appControl);
        //插入账目变动表信息
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(memberId);
        appMemberAccountChange.setOperaType(2);
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(goodsPrice);
        //获取更新后的金额
        AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
        appMemberAccountChange.setTotalMount(appMemberOpera.getBalance());
        appMemberAccountChange.setCreateBy(appMemberOpera.getUserAccount());
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChange.setOrderNo(orderSn);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appConveyMapper.insertSelective(appConvey);
    }

    //指派订单
    private int submitDistributionGoods(AppAssignGoods appGoods, Long memberId, Long channelId, String orderSn)
    throws Exception {
        //如果不是卡单
        if (appGoods.getHinder() == 0) {
            return smooth(appGoods, memberId, channelId, orderSn);
        }
        //如果是卡单
        if (appGoods.getHinder() == 1) {
            return stuck(appGoods, memberId, channelId, orderSn);
        }
        return 1;
    }

    private int smooth(AppAssignGoods appGoods, Long memberId, Long channelId, String orderSn) throws Exception {
        AppConvey appConvey = new AppConvey();
        //获取会员信息
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        BigDecimal goodsPrice = appGoods.getGoodsPrice();
        //获取会员等级
        AppMemberLevel appMemberLevel = appMemberLevelMapper.selectByPrimaryKey(appMember.getMemberLevelId());
        BigDecimal commission = appMemberLevel.getCommission();
        //佣金计算
        BigDecimal GrabCommission = goodsPrice.multiply(commission);
        appConvey.setCommission(GrabCommission);
        //设置商品订单id
        appConvey.setGoodsId(appGoods.getId());
        //设置渠道id
        appConvey.setChannelId(channelId);
        //设置会员id
        appConvey.setMemberId(appMember.getId());
        //生成订单号
        appConvey.setLno(orderSn);
        //设置本单金额
        appConvey.setAmount(appGoods.getGoodsPrice());
        //设置下单时间
        appConvey.setAddtime(DateFormat.getNowDate());
        //设置完成时间
        appConvey.setEndtime(DateFormat.getNowDate());
        //设置订单状态
        appConvey.setStatus("1");
        //设置佣金发放状态
        appConvey.setcStatus("1");
        //设置卡不卡单
        appConvey.setSign("0");
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("826");
        }
        //设置抢单数
        List<AppConvey> appConveys = appConveyMapper.selectConvey();
        if (null == appConveys || appConveys.size() == 0) {
            appConvey.setQiang(1L);
        } else {
            Long qiang = appConveys.stream()
                .map(e -> e.getQiang())
                .reduce(Long::max)
                .get();
            appConvey.setQiang(qiang + 1);
        }
        //修改会员余额金额
        AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
        appMemberBalanceParam.setMemberId(memberId);
        appMemberBalanceParam.setGoodsPrice(goodsPrice);
        appMemberBalanceParam.setBalance(appMember.getBalance());
        appMemberBalanceParam.setGrabCommission(GrabCommission);
        appMemberBalanceParam.setChannelId(channelId);
        appMemberMapper.updateMemberBalance(appMemberBalanceParam);
        //查询parentAgent
        appMemberMapper.selectParent();
        List<AppMember> appMembers = appMemberMapper.selectAppMemberParentAgent(memberId);
        //获取上下级代理佣金比例
        AppControl appControl = controlMapper.selectByChannelId(channelId);
        //更新parentAgentBalance
        calculateCommission(appMembers, goodsPrice, appControl);
        //插入账目变动表信息
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(memberId);
        appMemberAccountChange.setOperaType(2);
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(goodsPrice);
        //获取更新后的金额
        AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
        appMemberAccountChange.setTotalMount(appMemberOpera.getBalance());
        appMemberAccountChange.setCreateBy(appMemberOpera.getUserAccount());
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChange.setOrderNo(orderSn);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        //更新派单商品状态
        appGoods.setIsConsumed(1);
        appAssignGoodsMapper.updateByPrimaryKeySelective(appGoods);
        return appConveyMapper.insertSelective(appConvey);
    }

    private int stuck(AppAssignGoods appGoods, Long memberId, Long channelId, String orderSn) throws Exception {
        AppConvey appConvey = new AppConvey();
        //获取会员信息
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        BigDecimal goodsPrice = appGoods.getGoodsPrice();
        //获取会员等级
        AppMemberLevel appMemberLevel = appMemberLevelMapper.selectByPrimaryKey(appMember.getMemberLevelId());
        BigDecimal commission = appMemberLevel.getCommission();
        //佣金计算
        BigDecimal GrabCommission = goodsPrice.multiply(commission);
        appConvey.setCommission(GrabCommission);
        //设置商品订单id
        appConvey.setGoodsId(appGoods.getId());
        //设置渠道id
        appConvey.setChannelId(channelId);
        //设置会员id
        appConvey.setMemberId(appMember.getId());
        //生成订单号
        appConvey.setLno(orderSn);
        //设置本单金额
        appConvey.setAmount(appGoods.getGoodsPrice());
        //设置下单时间
        appConvey.setAddtime(DateFormat.getNowDate());
        //设置完成时间
        appConvey.setEndtime(DateFormat.getNowDate());
        //设置订单状态
        appConvey.setStatus("5");
        //设置佣金发放状态
        appConvey.setcStatus("2");
        //设置卡不卡单
        appConvey.setSign("1");
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("826");
        }
        //设置抢单数
        List<AppConvey> appConveys = appConveyMapper.selectConvey();
        if (null == appConveys || appConveys.size() == 0) {
            appConvey.setQiang(1L);
        } else {
            Long qiang = appConveys.stream()
                .map(e -> e.getQiang())
                .reduce(Long::max)
                .get();
            appConvey.setQiang(qiang + 1);
        }
        //判断是否是卡单的最后一单
        if (appGoods.getLastOrder() == 1 && appGoods.getLastOrder() != null) {
            int exchange = exchange(appGoods, memberId, channelId, orderSn, appConvey, appMember, goodsPrice,
                GrabCommission);
            if (exchange > 0) {
                Integer whichGroup = appGoods.getWhichGroup();
                Date goodsAddTime = appGoods.getGoodsAddTime();
                String date = DateFormat.dateToStr(goodsAddTime);
                //找出当前组的商品
                List<AppAssignGoods> appAssignGoods = appAssignGoodsMapper.selectGroupAssignGoods(whichGroup, date,
                    memberId, channelId);
                //释放冻结金额
                BigDecimal total = new BigDecimal(0);
                for (AppAssignGoods appAssignGood : appAssignGoods) {
                    BigDecimal single = appAssignGood.getGoodsPrice()
                        .multiply(commission);
                    total = total.add(single);
                }
                //更新账户金额
                appMemberMapper.updateBalanceByCommission(memberId, channelId, total);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, goodsPrice);
                //获取上下级代理佣金比例
                AppControl appControl = controlMapper.selectByChannelId(channelId);
                appMemberMapper.selectParent();
                List<AppMember> appMembers = appMemberMapper.selectAppMemberParentAgent(memberId);
                //更新代理账户
                updateParentBalanceByCommission(appAssignGoods, memberId, channelId, appControl, appMembers, orderSn);
                //更新派单商品状态
                appGoods.setIsConsumed(1);
                appAssignGoodsMapper.updateByPrimaryKeySelective(appGoods);
                appConveyMapper.insertSelective(appConvey);
            }
        } else {
            exchange(appGoods, memberId, channelId, orderSn, appConvey, appMember, goodsPrice, GrabCommission);
        }
        return 1;
    }

    private void insertAccountChange(Long memberId, Long channelId, String orderSn, AppMember appMember,
        BigDecimal goodsPrice) {
        //插入账目变动表信息
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(memberId);
        appMemberAccountChange.setOperaType(2);
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(goodsPrice);
        //获取更新后的金额
        AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
        appMemberAccountChange.setTotalMount(appMemberOpera.getBalance());
        appMemberAccountChange.setCreateBy(appMemberOpera.getUserAccount());
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChange.setOrderNo(orderSn);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
    }

    private void updateParentBalanceByCommission(List<AppAssignGoods> appAssignGoods, Long memberId, Long channelId,
        AppControl appControl, List<AppMember> appMembers, String orderSn) {
        BigDecimal upOneCommission = count(appAssignGoods, appControl.getUpOneCommission());
        BigDecimal upTwoCommission = count(appAssignGoods, appControl.getUpTwoCommission());
        BigDecimal upThreeCommission = count(appAssignGoods, appControl.getUpThreeCommission());
        BigDecimal upFourCommission = count(appAssignGoods, appControl.getUpFourCommission());
        BigDecimal upFiveCommission = count(appAssignGoods, appControl.getUpFiveCommission());
        for (AppMember appMember : appMembers) {
            Long memberLevelId = appMember.getMemberLevelId();
            if (memberLevelId == 1L) {
                appMemberMapper.updateBalanceByCommission(memberId, channelId, upOneCommission);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, upOneCommission);
            } else if (memberLevelId == 2L) {
                appMemberMapper.updateBalanceByCommission(memberId, channelId, upTwoCommission);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, upTwoCommission);
            } else if (memberLevelId == 3L) {
                appMemberMapper.updateBalanceByCommission(memberId, channelId, upThreeCommission);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, upThreeCommission);
            } else if (memberLevelId == 4L) {
                appMemberMapper.updateBalanceByCommission(memberId, channelId, upFourCommission);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, upFourCommission);
            } else if (memberLevelId == 5L) {
                appMemberMapper.updateBalanceByCommission(memberId, channelId, upFiveCommission);
                //插入账变信息
                insertAccountChange(memberId, channelId, orderSn, appMember, upFiveCommission);
            }
        }
    }

    private BigDecimal count(List<AppAssignGoods> appAssignGoods, BigDecimal commission) {
        //释放冻结金额
        BigDecimal total = new BigDecimal(0);
        for (AppAssignGoods appAssignGood : appAssignGoods) {
            BigDecimal single = appAssignGood.getGoodsPrice()
                .multiply(commission);
            total = total.add(single);
        }
        return total;
    }

    private int exchange(AppAssignGoods appGoods, Long memberId, Long channelId, String orderSn, AppConvey appConvey,
        AppMember appMember, BigDecimal goodsPrice, BigDecimal GrabCommission) {
        //冻结用户金额
        AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
        appMemberBalanceParam.setMemberId(memberId);
        appMemberBalanceParam.setGoodsPrice(goodsPrice);
        appMemberBalanceParam.setBalance(appMember.getBalance());
        appMemberBalanceParam.setGrabCommission(GrabCommission);
        appMemberBalanceParam.setChannelId(channelId);
        appMemberMapper.freezeBalance(appMemberBalanceParam);
        //查询parentAgent
        appMemberMapper.selectParent();
        List<AppMember> appMembers = appMemberMapper.selectAppMemberParentAgent(memberId);
        //获取上下级代理佣金比例
        AppControl appControl = controlMapper.selectByChannelId(channelId);
        //-------冻结上级代理佣金
        BigDecimal ParentAgentCommission = freezeParentAgentBalance(appMembers, goodsPrice, appControl);
        //插入账目变动表信息
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(memberId);
        appMemberAccountChange.setOperaType(3);
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(ParentAgentCommission);
        //获取更新后的金额
        AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
        appMemberAccountChange.setTotalMount(appMemberOpera.getBalance());
        appMemberAccountChange.setCreateBy(appMemberOpera.getUserAccount());
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChange.setOrderNo(orderSn);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        //更新派单商品状态
        appGoods.setIsConsumed(1);
        appAssignGoodsMapper.updateByPrimaryKeySelective(appGoods);
        appConveyMapper.insertSelective(appConvey);
        return 1;
    }

    /**
     * 冻结代理佣金
     */
    private BigDecimal freezeParentAgentBalance(List<AppMember> appMembers, BigDecimal goodsPrice,
        AppControl appControl) {
        for (AppMember appMember : appMembers) {
            Long id = appMember.getId();
            Long memberLevelId = appMember.getMemberLevelId();
            BigDecimal balance = appMember.getBalance();
            if (memberLevelId == 1L) {
                BigDecimal parentBalance = appMember.getBalance();
                BigDecimal commission = goodsPrice.multiply(appControl.getUpOneCommission());
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpOneCommission())));
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberBalanceParam.setGrabCommission(commission);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                appMemberMapper.updateAgentGrabCommission(appMemberBalanceParam);
                return commission;
            } else if (memberLevelId == 2L) {
                BigDecimal parentBalance = appMember.getBalance();
                BigDecimal commission = goodsPrice.multiply(appControl.getUpTwoCommission());
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpTwoCommission())));
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberBalanceParam.setGrabCommission(commission);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                appMemberMapper.updateAgentGrabCommission(appMemberBalanceParam);
                return commission;
            } else if (memberLevelId == 3L) {
                BigDecimal add = balance.add(goodsPrice.multiply(appControl.getUpThreeCommission()));
                BigDecimal commission = goodsPrice.multiply(appControl.getUpThreeCommission());
                appMember.setBalance(add);
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberBalanceParam.setGrabCommission(commission);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                appMemberMapper.updateAgentGrabCommission(appMemberBalanceParam);
                return commission;
            } else if (memberLevelId == 4L) {
                BigDecimal add = balance.add(goodsPrice.multiply(appControl.getUpFourCommission()));
                BigDecimal commission = goodsPrice.multiply(appControl.getUpFourCommission());
                appMember.setBalance(add);
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberBalanceParam.setGrabCommission(commission);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                appMemberMapper.updateAgentGrabCommission(appMemberBalanceParam);
                return commission;
            } else if (memberLevelId == 5L) {
                BigDecimal add = balance.add(goodsPrice.multiply(appControl.getUpFiveCommission()));
                BigDecimal commission = goodsPrice.multiply(appControl.getUpFiveCommission());
                appMember.setBalance(add);
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberBalanceParam.setGrabCommission(commission);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                appMemberMapper.updateAgentGrabCommission(appMemberBalanceParam);
                return commission;
            }
        }
        return null;
    }

    /**
     * 父级balance更新
     */
    private void calculateCommission(List<AppMember> appMembers, BigDecimal goodsPrice, AppControl appControl) {
        for (AppMember appMember : appMembers) {
            Long id = appMember.getId();
            Long memberLevelId = appMember.getMemberLevelId();
            BigDecimal balance = appMember.getBalance();
            if (memberLevelId == 1L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpOneCommission())));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else if (memberLevelId == 2L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpTwoCommission())));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else if (memberLevelId == 3L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpThreeCommission())));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else if (memberLevelId == 4L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpFourCommission())));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else if (memberLevelId == 5L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(appControl.getUpFiveCommission())));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            }
        }
    }

    /**
     * 生成订单编号
     */
    public String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("QD");
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        sb.append(date);
        int num = 0;
        for (int i = 0; i < 5000; i++) {
            num = (int) ((Math.random() * 9 + 1) * 100000);
        }
        String num_str = String.valueOf(num);
        sb.append(num_str);
        return sb.toString();
    }
}
