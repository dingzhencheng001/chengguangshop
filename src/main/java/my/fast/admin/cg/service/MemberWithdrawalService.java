package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.model.MemberWithdrawalParam;
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
    int approval(List<Long> ids, Integer type, Long channelId);

    /**
     * 驳回
     */
    @Transactional(rollbackFor = Exception.class)
    int rejectById(Long id, String remark, Long channelId);

    /**
     * 分页查询
     */
    List<AppMemberWithdrawalVo> findPage(Integer pageNum, Integer pageSize, Long channelId,
        MemberWithdrawalParam withdrawal);
}
