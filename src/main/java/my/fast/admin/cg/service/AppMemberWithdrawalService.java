package my.fast.admin.cg.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.model.WithdrawalParam;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/27 15:17
 */
public interface AppMemberWithdrawalService {

    /**
     *用户提现
     * @param channelId
     * @param memberId
     * @param withdrawalNum
     * @param appUserVO
     */
   @Transactional(rollbackFor = Exception.class)
   int withdrawal(Long channelId, Long memberId, BigDecimal withdrawalNum, AppMember appUserVO) throws Exception;


    /**
     * 分页查询
     */
    List<AppMemberWithdrawalVo> findPage(Long channelId, MemberWithdrawalParam withdrawal);

    /**
     * app提现分页查询
     */
    List<AppMemberWithdrawal> selectPage(WithdrawalParam withdrawalParam);
}
