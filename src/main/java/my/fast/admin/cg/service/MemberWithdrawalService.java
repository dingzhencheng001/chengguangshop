package my.fast.admin.cg.service;

import java.util.List;

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
    int approval(List<Long> ids, Integer status);

    /**
     * 驳回
     */
    int rejectById(Long id, String remark);

    /**
     * 分页查询
     */
    List<AppMemberWithdrawalVo> findPage(Integer pageNum, Integer pageSize, Long channelId,
        MemberWithdrawalParam withdrawal);
}
