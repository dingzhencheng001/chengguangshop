package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.model.AppApprovalParam;
import my.fast.admin.cg.model.AppWithdrawalParam;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.model.WithdrawalParam;
import my.fast.admin.cg.vo.AppMemberWithdrawalInfoVo;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 16:00
 */
public interface MemberWithdrawalService {

    /**
     * 批量审核
     */
    @Transactional(rollbackFor = Exception.class)
    int approval(AppApprovalParam appApprovalParam);

    /**
     * 驳回
     */
    @Transactional(rollbackFor = Exception.class)
    int rejectById(AppWithdrawalParam appWithdrawalParam);

    /**
     * 分页查询
     */
    List<AppMemberWithdrawalVo> findPage(MemberWithdrawalParam withdrawal);

    /**
     * 查询提现信息
     */
    AppMemberWithdrawalInfoVo getWithdrawalInfo(WithdrawalParam withdrawalParam);


}
