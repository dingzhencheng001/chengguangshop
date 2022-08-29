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
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.mapper.AppControlMapper;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberBankMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.AppMemberWithdrawalMapper;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.service.AppMemberWithdrawalService;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;
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
    @Autowired
    private AppControlMapper controlMapper;

    @Override
    public int withdrawal(Long channelId, Long memberId, BigDecimal withdrawalNum) throws Exception {
        AppMemberBank appMemberBank = appMemberBankMapper.selectByMemberId(memberId);
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        String orderSn = generateOrderSn();
        BigDecimal balance = appMember.getBalance();
        AppControl appControl = controlMapper.selectByChannelId(channelId);
        String startWithdraw = appControl.getStartWithdraw();
        String endWithdraw = appControl.getEndWithdraw();
        String stringDate = DateFormat.getStringDate();
        BigDecimal disposalAmount = balance.subtract(appMember.getFreezeBalance());
        int flag = withdrawalNum.compareTo(disposalAmount);
        if (flag >= 0) {
            throw new Exception("832");
        }
        if (StringUtils.isEmpty(appMemberBank)) {
            throw new Exception("827");
        }
        if (startWithdraw.compareTo(stringDate) < 0 && endWithdraw.compareTo(stringDate) > 0) {
            //修改账户余额并且冻结金额
            appMemberMapper.updateBalance(channelId, memberId, withdrawalNum);
            BigDecimal nowBalance = appMemberMapper.selectByPrimaryKey(memberId)
                .getBalance();
            //插入提现表
            AppMemberWithdrawal appMemberWithdrawal = new AppMemberWithdrawal();
            appMemberWithdrawal.setOrderNo(orderSn);
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
            appMemberAccountChange.setMemberId(memberId);
            appMemberAccountChange.setOperaType(3);
            appMemberAccountChange.setOperaMount(withdrawalNum);
            appMemberAccountChange.setCreateBy(appMember.getUserAccount());
            appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
            appMemberAccountChange.setChannelId(channelId);
            appMemberAccountChange.setPreOperaMount(balance);
            appMemberAccountChange.setTotalMount(nowBalance);
            appMemberAccountChange.setStatus(1);
            appMemberAccountChange.setOrderNo(orderSn);
            appMemberAccountChange.setUserAccount(appMember.getUserAccount());
            appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
            return appMemberWithdrawalMapper.insertSelective(appMemberWithdrawal);
        } else {
            throw new Exception("828");
        }
    }

    @Override
    public List<AppMemberWithdrawalVo> findPage(Long channelId, MemberWithdrawalParam memberWithdrawalParam) {
        PageHelper.startPage(memberWithdrawalParam.getPageNum(), memberWithdrawalParam.getPageSize());
        return appMemberWithdrawalMapper.selectWithdrawalList(channelId, memberWithdrawalParam);
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
