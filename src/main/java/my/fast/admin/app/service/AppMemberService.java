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
public interface AppMemberService {

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
    
    /**
     * 查询会员
     * 
     * @param id 会员id
     * @return 会员
     */
    public AppMember selectAppMemberByUserId(Long id);
    
    /**
     * 查询会员
     * 
     * @param userAccount 会员名称
     * @return 会员
     */
    public AppMember selectAppMemberByUserAccount(String userAccount);
    
    
    /**
     * 根据邀请码查询上级会员用户
     * 
     * @param reCode 会员邀请码
     * @return 上级会员用户
     */
    public AppMember selectAppMemberByCode(String reCode);
    
    /**
     * 校验用户名称是否唯一
     * 
     * @param userName 用户名称
     * @return 结果
     */
    public String checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(AppMember appMember);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(AppMember appMember);
    
    
    
    
    
}
