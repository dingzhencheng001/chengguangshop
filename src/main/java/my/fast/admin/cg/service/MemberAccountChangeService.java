package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.model.AccountChangeParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 15:14
 */
public interface MemberAccountChangeService {

    /**
     * 获取个人账户变更列表
     */
    List<AppMemberAccountChange> getMemberList(Integer pageNum, Integer pageSize, Long channelId, Long memberId,
        AccountChangeParam accountChangeParam);
    /**
     * 删除用户账变信息
     */
    int deleteAccountChangeById(Long id,Long channelId);

    /**
     * 更新用户账变信息
     */
    @Transactional(rollbackFor = Exception.class)
    int updateAccountChange(Long id, AppMemberAccountChange appMemberAccountChange, Long channelId);

    /**
     * 创建用户账变信息
     */
    int createAccountChange(AppMemberAccountChange appMemberAccountChange, Long channelId);


}
