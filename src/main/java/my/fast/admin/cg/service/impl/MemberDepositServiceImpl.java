package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppControl;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.AppMemberDepositExample;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.mapper.AppControlMapper;
import my.fast.admin.cg.mapper.AppConveyMapper;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberDepositMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.SysOperateLogMapper;
import my.fast.admin.cg.model.AppMemberBalanceParam;
import my.fast.admin.cg.model.ListDepositParam;
import my.fast.admin.cg.model.MemberDepositParam;
import my.fast.admin.cg.service.MemberDepositService;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.DateFormat;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 11:52
 */
@Service
public class MemberDepositServiceImpl implements MemberDepositService {

    @Autowired
    private AppMemberDepositMapper depositMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;

    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Autowired
    private AppConveyMapper appConveyMapper;

    @Autowired
    private AppControlMapper controlMapper;

    @Override
    public List<AppMemberDeposit> listDeposit(ListDepositParam deposit, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberDepositExample listExample = new AppMemberDepositExample();
        AppMemberDepositExample.Criteria criteria = listExample.createCriteria();
        criteria.andChannelIdEqualTo(deposit.getChannelId());
        if (!StringUtils.isEmpty(deposit.getOrderNo())) {
            criteria.andOrderNoEqualTo(deposit.getOrderNo());
        }
        if (!StringUtils.isEmpty(deposit.getUserAccount())) {
            criteria.andUserAccountEqualTo(deposit.getUserAccount());
        }
        if (!StringUtils.isEmpty(deposit.getPhoneNumber())) {
            criteria.andPhoneNumberEqualTo(deposit.getPhoneNumber());
        }
        if (!StringUtils.isEmpty(deposit.getSelectBeginTime())) {
            criteria.andCreateTimeBetween(deposit.getSelectBeginTime(), deposit.getSelectEndTime());
        }
        return depositMapper.selectByExample(listExample);
    }

    @Override
    public int deleteDepositById(Long id) {
        return depositMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createDeposit(MemberDepositParam depositParam) {
        int type = 1; //1 充值 2 减少
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        AppMemberDeposit deposit = new AppMemberDeposit();
        SysOperateLog operateLog = new SysOperateLog();
        deposit.setOrderNo(generateOrderSn());//设置订单编号
        //获取用户信息 更新用户的余额
        AppMember appMember = appMemberMapper.selectByPrimaryKey(depositParam.getMemberId());
        if (StringUtils.isEmpty(appMember)) {
            try {
                throw new Exception("824");
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        if (depositParam.getOperaMount()
            .compareTo(BigDecimal.ZERO) < 0) {//减少
            type = 2;
            System.out.println("负数 减少 ");
            //余额判断
            if (CommonUtils.moneyComp(depositParam.getOperaMount(), appMember.getBalance())) {
                try {
                    throw new Exception("831");
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            //余额计算
            //账变金额计算
        } else {//充值
            System.out.println("正数 充值");
        }
        appMember.setBalance(CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
        appMemberAccountChange.setTotalMount(
            CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
        //更新会员表
        appMemberMapper.updateByPrimaryKey(appMember);
        //插入账变记录表
        appMemberAccountChange.setUserAccount(appMember.getUserAccount());//记录操作信息
        appMemberAccountChange.setOrderNo(deposit.getOrderNo()); //取订单编号
        appMemberAccountChange.setStatus(1);
        appMemberAccountChange.setMemberId(depositParam.getMemberId());
        appMemberAccountChange.setChannelId(depositParam.getChannelId());
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(depositParam.getOperaMount());
        //设置操作后金额
        appMemberAccountChange.setOperaType(type); //1 充值 2 减少
        appMemberAccountChange.setCreateBy("admin");
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        //操作记录
        operateLog.setChannelId(depositParam.getChannelId());
        operateLog.setTitle("会员充值");
        operateLog.setOperateContent("账号为：" + appMember.getUserAccount() + " 的会员，在" + DateFormat.getNowDate() + "充值了金额"
            + depositParam.getOperaMount() + " 元。");
        operateLog.setCreateBy("admin");
        operateLog.setCreateTime(DateFormat.getNowDate());
        operateLog.setRemark("该操作订单编号为" + deposit.getOrderNo());
        sysOperateLogMapper.insertSelective(operateLog);
        //插入充值记录
        deposit.setMemberId(depositParam.getMemberId());
        deposit.setUpdateBy("" + appMember.getParentUserId());//记录上级ID
        deposit.setChannelId(depositParam.getChannelId());
        deposit.setPhoneNumber(appMember.getPhoneNumber());
        deposit.setOperaMount(depositParam.getOperaMount());
        deposit.setOperaType(type);
        deposit.setStatus(3);
        deposit.setUserAccount(appMember.getUserAccount());
        deposit.setRealName(appMember.getUserAccount());
        deposit.setCreateBy("admin");
        deposit.setCreateTime(DateFormat.getNowDate());
        deposit.setIsDelete(0);
        depositMapper.insertSelective(deposit);
        //充值成功后,付未支付的订单
        payment(depositParam, appMember);
        return 1;
    }

    private int payment(MemberDepositParam depositParam, AppMember appMember) {
        //充值成功后,付未支付的订单
        List<AppConvey> appConveys = appConveyMapper.selectMemberConvey(depositParam);
        if (appConveys.size() > 0) {
            BigDecimal balance = appMember.getBalance();
            //如果有未支付,則完成交易
            for (AppConvey appConvey : appConveys) {
                BigDecimal subtract = balance.subtract(appConvey.getAmount());
                //判断用户余额是否够扣
                //账户余额够扣
                if (subtract.intValue() >= 0) {
                    String orderSn = generateOrderSn();
                    BigDecimal goodsPrice = appConvey.getAmount();
                    Long memberId = depositParam.getMemberId();
                    Long channelId = depositParam.getChannelId();
                    BigDecimal commission = appConvey.getCommission();
                    AppMemberBalanceParam appMemberBalanceParam = new AppMemberBalanceParam();
                    appMemberBalanceParam.setMemberId(memberId);
                    appMemberBalanceParam.setGoodsPrice(goodsPrice);
                    appMemberBalanceParam.setBalance(appMember.getBalance());
                    appMemberBalanceParam.setGrabCommission(commission);
                    appMemberBalanceParam.setChannelId(channelId);
                    appMemberMapper.updateMemberBalance(appMemberBalanceParam);
                    //查询parentAgent
                    appMemberMapper.selectParent();
                    List<AppMember> appMembers = appMemberMapper.selectAppMemberParentAgent(memberId);
                    //获取上下级代理佣金比例
                    AppControl appControl = controlMapper.selectByChannelId(depositParam.getChannelId());
                    //更新parentAgentBalance
                    calculateCommission(appMembers, goodsPrice, appControl);
                    //插入账目变动表信息
                    AppMemberAccountChange accountChange = new AppMemberAccountChange();
                    accountChange.setMemberId(memberId);
                    accountChange.setOperaType(2);
                    accountChange.setPreOperaMount(appMember.getBalance());
                    accountChange.setOperaMount(goodsPrice);
                    //获取更新后的金额
                    AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
                    accountChange.setTotalMount(appMemberOpera.getBalance());
                    accountChange.setCreateBy(appMemberOpera.getUserAccount());
                    accountChange.setCreateTime(DateFormat.getNowDate());
                    accountChange.setChannelId(channelId);
                    accountChange.setOrderNo(orderSn);
                    appMemberAccountChangeMapper.insertSelective(accountChange);
                    //设置订单状态
                    appConvey.setStatus("1");
                    //设置订单状态
                    appConvey.setcStatus("1");
                    //设置交易完成时间
                    appConvey.setEndtime(DateFormat.getNowDate());
                    appConveyMapper.updateByPrimaryKey(appConvey);
                } else {
                    //不够扣
                    return 1;
                }
            }
        }
        return 1;
    }

    /**
     * 生成订单编号
     */
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("SY");
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
}
