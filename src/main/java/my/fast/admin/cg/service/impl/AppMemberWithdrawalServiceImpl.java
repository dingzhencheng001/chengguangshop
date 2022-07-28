package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberBankMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.AppMemberWithdrawalMapper;
import my.fast.admin.cg.service.AppMemberWithdrawalService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/27 15:20
 */
@Service
public class AppMemberWithdrawalServiceImpl implements AppMemberWithdrawalService {

    @Autowired
    private AppMemberMapper appMemberMapper;
    @Autowired
    private AppMemberBankMapper appMemberBankMapper;
    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;
    @Autowired
    private AppMemberWithdrawalMapper appMemberWithdrawalMapper;


    @Override
    public int withdrawal(Long channelId, Long memberId, BigDecimal withdrawalNum) throws Exception {
        AppMemberBank appMemberBank = appMemberBankMapper.selectByMemberId(memberId);
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        BigDecimal balance = appMember.getBalance();
        if (StringUtils.isEmpty(appMemberBank)) {
            throw new Exception("没有绑定银行卡");
        }
        //修改账户余额并且冻结金额
        appMemberMapper.updateBalance(channelId, memberId, withdrawalNum);
        BigDecimal nowBalance = appMemberMapper.selectByPrimaryKey(memberId)
            .getBalance();
        //插入提现表
        AppMemberWithdrawal appMemberWithdrawal = new AppMemberWithdrawal();
        appMemberWithdrawal.setOrderNo(generateOrderSn());
        appMemberWithdrawal.setMemberId(memberId);
        appMemberWithdrawal.setUserAccount(appMember.getUserAccount());
        appMemberWithdrawal.setRealName(appMemberBank.getAccountName());
        appMemberWithdrawal.setPhoneNumber(appMember.getPhoneNumber());
        appMemberWithdrawal.setOperaType(4);
        appMemberWithdrawal.setStatus(1);
        appMemberWithdrawal.setOperaMount(withdrawalNum);
        appMemberWithdrawal.setCreateBy(appMember.getUserAccount());
        appMemberWithdrawal.setCreateTime(DateFormat.getNowDate());
        appMemberWithdrawal.setChannelId(channelId);
        appMemberWithdrawal.setMemberBankId(appMemberBank.getId());
        //插入账变
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(
            memberId);
        appMemberAccountChange.setOperaType(3);
        appMemberAccountChange.setOperaMount(withdrawalNum);
        appMemberAccountChange.setCreateBy(appMember.getUserAccount());
        appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
        appMemberAccountChange.setChannelId(channelId);
        appMemberAccountChange.setPreOperaMount(balance);
        appMemberAccountChange.setTotalMount(nowBalance);
        appMemberAccountChange.setStatus(1);
        appMemberAccountChange.setOrderNo(appMemberWithdrawal.getOrderNo());
        appMemberAccountChange.setUserAccount(appMember.getUserAccount());
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appMemberWithdrawalMapper.insertSelective(appMemberWithdrawal);
    }

    /**
     * 生成订单编号
     */
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("TX");
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
