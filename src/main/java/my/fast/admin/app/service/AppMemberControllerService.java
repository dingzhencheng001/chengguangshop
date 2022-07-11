package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.app.entity.AppMember;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:38
 */
public interface AppMemberControllerService {

    /**
     * 获取所有会员
     */
    List<AppMember> listAll();

    /**
     * 分页查询
     */
    List<AppMember> listMember(AppMember appMember, Integer pageNum, Integer pageSize);

    /**
     * 删除会员
     */
    int deleteMemberById(Long id);

    /**
     * 创建会员
     */
    int createMember(AppMember appMember);

    /**
     * 修改会员
     */
    @Transactional
    int updateMember(Long id,AppMember appMember);
    
    
}
