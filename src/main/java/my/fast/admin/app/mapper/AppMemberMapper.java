package my.fast.admin.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.AppMemberExample;

public interface AppMemberMapper {
    long countByExample(AppMemberExample example);

    int deleteByExample(AppMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMember record);

    int insertSelective(AppMember record);

    List<AppMember> selectByExampleWithBLOBs(AppMemberExample example);

    List<AppMember> selectByExample(AppMemberExample example);

    AppMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMember record, @Param("example") AppMemberExample example);

    int updateByExampleWithBLOBs(@Param("record") AppMember record, @Param("example") AppMemberExample example);

    int updateByExample(@Param("record") AppMember record, @Param("example") AppMemberExample example);

    int updateByPrimaryKeySelective(AppMember record);

    int updateByPrimaryKeyWithBLOBs(AppMember record);

    int updateByPrimaryKey(AppMember record);
    
    AppMember selectAppMemberByUserAccount(String userAccount);
    
    AppMember selectAppMemberByCode(String code);
    
    /**
     * 校验用户名称是否唯一
     * @return 结果
     */
    public int checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     * @return 结果
     */
    public AppMember checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     * @return 结果
     */
    public AppMember checkEmailUnique(String email);
    
    
}