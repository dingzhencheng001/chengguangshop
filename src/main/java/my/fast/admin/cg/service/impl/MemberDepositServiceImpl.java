package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.AppMemberDepositExample;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberDepositMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.SysOperateLogMapper;
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
    
    @Override
    public List<AppMemberDeposit> listDeposit(ListDepositParam deposit, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberDepositExample  listExample = new AppMemberDepositExample();
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
    	Integer type = 1; //1 充值 2 减少
    	AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
    	AppMemberDeposit deposit = new AppMemberDeposit();
    	SysOperateLog  operateLog = new SysOperateLog();
    	deposit.setOrderNo(generateOrderSn());//设置订单编号
    	//获取用户信息 更新用户的余额
        AppMember appMember = appMemberMapper.selectByPrimaryKey(depositParam.getMemberId());
        if (StringUtils.isEmpty(appMember)) {
            try {
				throw new Exception("会员不存在");
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
        }
    	if(depositParam.getOperaMount().compareTo(BigDecimal.ZERO)==-1){//减少
    		type = 2 ;
    		System.out.println("负数 减少 ");
    		//余额判断
    		if(CommonUtils.moneyComp(depositParam.getOperaMount(),appMember.getBalance())){
    			try {
					throw new Exception("余额不足，无法扣减");
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
    		}
    		//余额计算
            appMember.setBalance(CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
            //账变金额计算
            appMemberAccountChange.setTotalMount(CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
    	}else{//充值
    		System.out.println("正数 充值");
    		appMember.setBalance(CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
    		appMemberAccountChange.setTotalMount(CommonUtils.moneyAdd(appMember.getBalance(), depositParam.getOperaMount()));
    	}
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
        operateLog.setOperateContent("账号为："+appMember.getUserAccount()+" 的会员，在"+DateFormat.getNowDate()+"充值了金额"+depositParam.getOperaMount()+" 元。");
        operateLog.setCreateBy("admin");
        operateLog.setCreateTime(DateFormat.getNowDate());
        operateLog.setRemark("该操作订单编号为"+deposit.getOrderNo());
        sysOperateLogMapper.insertSelective(operateLog);
        //插入充值记录
    	deposit.setMemberId(depositParam.getMemberId());
    	deposit.setUpdateBy(""+appMember.getParentUserId());//记录上级ID
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
    	
        return depositMapper.insertSelective(deposit);
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
}
