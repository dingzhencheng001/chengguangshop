package my.fast.admin.cg.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMemberLevel;

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
     */
   @Transactional(rollbackFor = Exception.class)
   int withdrawal(Long channelId, Long memberId, BigDecimal withdrawalNum) throws Exception;

}
