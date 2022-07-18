package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.app.entity.AppMemberAccountChange;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:38
 */
public interface AppMemberAccountChangeControllerService {

    /**
     * 获取所有用户账变记录
     */
    List<AppMemberAccountChange> listAll();

    /**
     * 查询个人账户情况
     */
    List<AppMemberAccountChange> listAccountChange(Integer type, Long memberId,Integer pageNum, Integer pageSize);

    /**
     * 获取个人账户变更列表
     */
    List<AppMemberAccountChange> getMemberList(Integer pageNum, Integer pageSize);

    /**
     * 删除用户账变
     */
    int deleteAccountChangeById(Long id);

    /**
     * 创建用户账变
     */
    int createAccountChange(AppMemberAccountChange appMemberAccountChange);

    /**
     * 修改用户账变
     */
    @Transactional
    int updateAccountChange(Long id,AppMemberAccountChange appMemberAccountChange);


}
