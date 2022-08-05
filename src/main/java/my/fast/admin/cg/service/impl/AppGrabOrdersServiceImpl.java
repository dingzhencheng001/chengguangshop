package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.mapper.AppAssignGoodsMapper;
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

    @Override
    public Map<String, Object> randomOrders(AppRandomOrderParam appRandomOrderParam) throws Exception {
        Long memberId = appRandomOrderParam.getMemberId();
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        if (StringUtils.isEmpty(appMember)) {
            throw new Exception("会员不存在");
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
                throw new Exception("抢单数超过会员等级限制");
            }
        }
        return getObject(appRandomOrderParam, appMember);
    }

    public Map<String, Object> getObject(AppRandomOrderParam appRandomOrderParam, AppMember appMember) {
        Map<String, Object> remap = new HashMap<>();
        //先查出派单商品列表
        List<AppAssignGoods> assignGoodsList = appAssignGoodsMapper.assignGoodsList(appRandomOrderParam);
        if (assignGoodsList != null && assignGoodsList.size() > 0) {
            //排序
            Collections.sort(assignGoodsList, new Comparator<AppAssignGoods>() {
                @Override
                public int compare(AppAssignGoods o1, AppAssignGoods o2) {
                    //升序
                    return o1.getOrderQuantity()
                        .compareTo(o2.getOrderQuantity());
                }
            });
            //先获取派单商品表数据
            LinkedList<AppAssignGoods> appAssignGoodsLinkedList = new LinkedList<>();
            LinkedList<AppAssignGoods> appAssignGoods = assignGoodsList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
            AppAssignGoods first = appAssignGoods.getFirst();
            appAssignGoodsLinkedList.add(first);
            AppAssignGoods distributionGoods = appAssignGoodsLinkedList.getFirst();
            remap.put("distributionGoods", distributionGoods);
            //更新订单状态
            distributionGoods.setIsConsumed(1);
            appAssignGoodsMapper.updateByPrimaryKeySelective(distributionGoods);
        } else { //派单为空,随机生成订单
            Object traditionGoods = randomGoods(appMember);
            remap.put("traditionGoods", traditionGoods);
        }
        return remap;
    }

    //随机生成订单
    public Object randomGoods(AppMember appMember) {
        Object appGoods = new AppGoods();
        if (!StringUtils.isEmpty(appMember)) {
            BigDecimal balance = appMember.getBalance();
            //先写死,后续从规则里面获取
            BigDecimal rate = new BigDecimal("0.5");
            BigDecimal useBalance = balance.multiply(rate);
            appGoods = appGoodsMapper.randomOrders(useBalance);
        }
        return appGoods;
    }

    @Override
    public int submitOrders(Map<String, Object> goods, Long memberId, Long channelId) throws Exception {
        //传统订单
        AppGoods appGoods = (AppGoods) goods.get("traditionGoods");
        if (!StringUtils.isEmpty(appGoods)) {
            return submitTraditionOrders(appGoods, memberId, channelId);
        }
        //指派订单
        AppAssignGoods distributionGoods = (AppAssignGoods) goods.get("distributionGoods");
        if (!StringUtils.isEmpty(distributionGoods)) {
            return submitDistributionGoods(distributionGoods, memberId, channelId);
        }
        return 1;
    }

    //传统订单
    private int submitTraditionOrders(AppGoods appGoods, Long memberId, Long channelId) throws Exception {
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
        appConvey.setLno(generateOrderSn());
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
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("会员收货地址不存在");
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
        calculateCommission(appMembers, goodsPrice);
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
        Date date = new Date(System.currentTimeMillis());
        appMemberAccountChange.setCreateTime(date);
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appConveyMapper.insertSelective(appConvey);
    }

    //指派订单
    private int submitDistributionGoods(AppAssignGoods appGoods, Long memberId, Long channelId) throws Exception {
        //如果不是是卡单
        if (appGoods.getHinder() == 0) {
            return smooth(appGoods, memberId, channelId);
        }
        //如果是卡单
        if (appGoods.getHinder() == 1) {
            return stuck(appGoods, memberId, channelId);
        }
      return 1;
    }

    private int smooth(AppAssignGoods appGoods, Long memberId, Long channelId) throws Exception {
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
        appConvey.setLno(generateOrderSn());
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
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("会员收货地址不存在");
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
        calculateCommission(appMembers, goodsPrice);
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
        Date date = new Date(System.currentTimeMillis());
        appMemberAccountChange.setCreateTime(date);
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appConveyMapper.insertSelective(appConvey);
    }

    private int stuck(AppAssignGoods appGoods, Long memberId, Long channelId) throws Exception {
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
        appConvey.setLno(generateOrderSn());
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
        //设置会员收货地址id
        AppMemberAddress appMemberAddress = appMemberAddressMapper.selectByMemberId(memberId);
        if (!StringUtils.isEmpty(appMemberAddress)) {
            appConvey.setAddId(appMemberAddress.getId());
        } else {
            throw new Exception("会员收货地址不存在");
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
        calculateCommission(appMembers, goodsPrice);
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
        Date date = new Date(System.currentTimeMillis());
        appMemberAccountChange.setCreateTime(date);
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appConveyMapper.insertSelective(appConvey);
    }

    /**
     * 父级balance更新
     */
    private void calculateCommission(List<AppMember> appMembers, BigDecimal goodsPrice) {

        for (AppMember appMember : appMembers) {
            Long id = appMember.getId();
            Long memberLevelId = appMember.getMemberLevelId();
            BigDecimal balance = appMember.getBalance();
            if (memberLevelId == 1L) {
                BigDecimal parentBalance = appMember.getBalance();
                appMember.setBalance(balance.add(goodsPrice.multiply(new BigDecimal(0.09))));
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else if (memberLevelId == 2L) {
                appMember.setBalance(balance.add(goodsPrice.multiply(new BigDecimal(0.06))));
                BigDecimal parentBalance = appMember.getBalance();
                AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                appMemberBalanceParam.setBalance(parentBalance);
                appMemberBalanceParam.setMemberId(id);
                appMemberMapper.updateAgentBalance(appMemberBalanceParam);
            } else {
                BigDecimal add = balance.add(goodsPrice.multiply(new BigDecimal(0.01)));
                if (memberLevelId == 3L) {
                    appMember.setBalance(add);
                    BigDecimal parentBalance = appMember.getBalance();
                    AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                    appMemberBalanceParam.setBalance(parentBalance);
                    appMemberBalanceParam.setMemberId(id);
                    appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                } else if (memberLevelId == 4L) {
                    appMember.setBalance(add);
                    BigDecimal parentBalance = appMember.getBalance();
                    AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                    appMemberBalanceParam.setBalance(parentBalance);
                    appMemberBalanceParam.setMemberId(id);
                    appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                } else if (memberLevelId == 5L) {
                    appMember.setBalance(add);
                    BigDecimal parentBalance = appMember.getBalance();
                    AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                    appMemberBalanceParam.setBalance(parentBalance);
                    appMemberBalanceParam.setMemberId(id);
                    appMemberMapper.updateAgentBalance(appMemberBalanceParam);
                }
            }
        }
    }

    /**
     * 生成订单编号
     */
    public String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("UB");
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
