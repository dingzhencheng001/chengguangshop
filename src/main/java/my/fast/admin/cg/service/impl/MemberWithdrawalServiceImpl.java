package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.entity.AppMemberWithdrawalExample;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.mapper.AppMemberWithdrawalMapper;
import my.fast.admin.cg.mapper.SysOperateLogMapper;
import my.fast.admin.cg.model.AppApprovalParam;
import my.fast.admin.cg.model.AppWithdrawalParam;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.service.MemberWithdrawalService;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;
import my.fast.admin.framework.utils.DateFormat;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 16:01
 */
@Service
public class MemberWithdrawalServiceImpl implements MemberWithdrawalService {

    @Autowired
    private AppMemberWithdrawalMapper appMemberWithdrawalMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;
    
    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Override
    public int approval(AppApprovalParam appApprovalParam) {
        //通过
        if (appApprovalParam.getStatus() == 1) {
            AppMemberWithdrawal record = new AppMemberWithdrawal();
            record.setOperaType(appApprovalParam.getStatus());
            AppMemberWithdrawalExample example = new AppMemberWithdrawalExample();
            example.createCriteria()
                .andIdIn(appApprovalParam.getIds());
            appMemberWithdrawalMapper.updateByExampleSelective(record, example);
            //更新用户账户金额和修改冻结金额
            example.createCriteria()
                .andChannelIdIn(appApprovalParam.getIds());
            List<AppMemberWithdrawal> appMemberWithdrawalList = appMemberWithdrawalMapper.selectByExample(example);
            for (AppMemberWithdrawal appMemberWithdrawal : appMemberWithdrawalList) {
            	SysOperateLog  operateLog = new SysOperateLog();
                Long memberId = appMemberWithdrawal.getMemberId();
                AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
                BigDecimal operaMount = appMemberWithdrawal.getOperaMount();
                appMemberMapper.changeBalance(appApprovalParam.getChannelId(), memberId, operaMount);
                //操作记录
                operateLog.setChannelId(appMember.getChannelId());
                operateLog.setTitle("提现通过");
                operateLog.setOperateContent("账号为："+appMember.getUserAccount()+" 的会员提现请求，在"+DateFormat.getNowDate()+"已通过。");
                operateLog.setCreateBy("admin");
                operateLog.setCreateTime(DateFormat.getNowDate());
                operateLog.setRemark("该操作订单编号为"+appMemberWithdrawal.getOrderNo());
                sysOperateLogMapper.insertSelective(operateLog);
                //插入账变信息表
                AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
                appMemberAccountChange.setMemberId(memberId);
                appMemberAccountChange.setOperaType(3);
                appMemberAccountChange.setOperaMount(operaMount);
                appMemberAccountChange.setCreateBy(appMember.getUserAccount());
                appMemberAccountChange.setUserAccount(appMember.getUserAccount());
                appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
                appMemberAccountChange.setChannelId(appApprovalParam.getChannelId());
                appMemberAccountChange.setPreOperaMount(appMember.getBalance());
                appMemberAccountChange.setTotalMount(appMember.getBalance());
                appMemberAccountChange.setStatus(1);
                appMemberAccountChange.setOrderNo(appMemberWithdrawal.getOrderNo());
                appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
            }
        }
        //拒绝
        if (appApprovalParam.getStatus() == 2) {
            AppMemberWithdrawal record = new AppMemberWithdrawal();
            record.setOperaType(appApprovalParam.getStatus());
            AppMemberWithdrawalExample example = new AppMemberWithdrawalExample();
            example.createCriteria()
                .andIdIn(appApprovalParam.getIds());
            appMemberWithdrawalMapper.updateByExampleSelective(record, example);
            //更新用户账户金额和修改冻结金额
            example.createCriteria()
                .andChannelIdIn(appApprovalParam.getIds());
            List<AppMemberWithdrawal> appMemberWithdrawalList = appMemberWithdrawalMapper.selectByExample(example);
            for (AppMemberWithdrawal appMemberWithdrawal : appMemberWithdrawalList) {
            	SysOperateLog  operateLog = new SysOperateLog();
                Long memberId = appMemberWithdrawal.getMemberId();
                AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
                BigDecimal balance = appMember.getBalance()
                    .subtract(appMemberWithdrawal.getOperaMount());
                BigDecimal operaMount = appMemberWithdrawal.getOperaMount();
                appMemberMapper.rollbackBalance(appApprovalParam.getChannelId(), memberId, operaMount);
                //操作记录
                operateLog.setChannelId(appMember.getChannelId());
                operateLog.setTitle("提现拒绝");
                operateLog.setOperateContent("账号为："+appMember.getUserAccount()+" 的会员提现请求，在"+DateFormat.getNowDate()+"被拒绝。");
                operateLog.setCreateBy("admin");
                operateLog.setCreateTime(DateFormat.getNowDate());
                operateLog.setRemark("该操作订单编号为"+appMemberWithdrawal.getOrderNo());
                sysOperateLogMapper.insertSelective(operateLog);
                //插入账变信息表
                AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
                appMemberAccountChange.setMemberId(memberId);
                appMemberAccountChange.setOperaType(3);
                appMemberAccountChange.setOperaMount(operaMount);
                appMemberAccountChange.setCreateBy(appMember.getUserAccount());
                appMemberAccountChange.setUserAccount(appMember.getUserAccount());
                appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
                appMemberAccountChange.setChannelId(appApprovalParam.getChannelId());
                appMemberAccountChange.setPreOperaMount(balance);
                appMemberAccountChange.setTotalMount(appMember.getBalance());
                appMemberAccountChange.setStatus(1);
                appMemberAccountChange.setOrderNo(appMemberWithdrawal.getOrderNo());
                appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
            }
        }
        return 1;
    }

    @Override
    public int rejectById(AppWithdrawalParam appWithdrawalParam) {
        AppMemberWithdrawal record = new AppMemberWithdrawal();
        record.setStatus(2);
        record.setRemark(appWithdrawalParam.getRemark());
        AppMemberWithdrawalExample example = new AppMemberWithdrawalExample();
        example.createCriteria()
            .andIdEqualTo(appWithdrawalParam.getId());
        appMemberWithdrawalMapper.updateByExampleSelective(record, example);
        //更新用户账户金额和修改冻结金额
        example.createCriteria()
            .andIdEqualTo(appWithdrawalParam.getId());
        List<AppMemberWithdrawal> appMemberWithdrawalList = appMemberWithdrawalMapper.selectByExample(example);
        for (AppMemberWithdrawal appMemberWithdrawal : appMemberWithdrawalList) {
        	SysOperateLog  operateLog = new SysOperateLog();
            Long memberId = appMemberWithdrawal.getMemberId();
            AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
            BigDecimal balance = appMember.getBalance()
                .subtract(appMemberWithdrawal.getOperaMount());
            BigDecimal operaMount = appMemberWithdrawal.getOperaMount();
            appMemberMapper.rollbackBalance(appWithdrawalParam.getChannelId(), memberId, operaMount);
            //操作记录
            operateLog.setChannelId(appMember.getChannelId());
            operateLog.setTitle("驳回提现");
            operateLog.setOperateContent("账号为："+appMember.getUserAccount()+" 的会员提现请求，在"+DateFormat.getNowDate()+"被驳回。");
            operateLog.setCreateBy("admin");
            operateLog.setCreateTime(DateFormat.getNowDate());
            operateLog.setRemark("该操作订单编号为"+appMemberWithdrawal.getOrderNo());
            sysOperateLogMapper.insertSelective(operateLog);
            //插入账变信息表
            AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
            appMemberAccountChange.setMemberId(memberId);
            appMemberAccountChange.setOperaType(3);
            appMemberAccountChange.setOperaMount(operaMount);
            appMemberAccountChange.setCreateBy(appMember.getUserAccount());
            appMemberAccountChange.setUserAccount(appMember.getUserAccount());
            appMemberAccountChange.setCreateTime(DateFormat.getNowDate());
            appMemberAccountChange.setChannelId(appWithdrawalParam.getChannelId());
            appMemberAccountChange.setPreOperaMount(balance);
            appMemberAccountChange.setTotalMount(appMember.getBalance());
            appMemberAccountChange.setStatus(1);
            appMemberAccountChange.setOrderNo(appMemberWithdrawal.getOrderNo());
            appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        }
        return 1;

}

    @Override
    public List<AppMemberWithdrawalVo> findPage(Integer pageNum, Integer pageSize, Long channelId,
        MemberWithdrawalParam memberWithdrawalParam) {
        PageHelper.startPage(pageNum, pageSize);
        return appMemberWithdrawalMapper.selectWithdrawalList(channelId, memberWithdrawalParam);
    }
}
