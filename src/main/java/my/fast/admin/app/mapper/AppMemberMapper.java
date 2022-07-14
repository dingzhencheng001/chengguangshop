package my.fast.admin.app.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.AppMemberExample;
import my.fast.admin.app.model.AppMemberBalancePram;

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
     *
     * @return 结果
     */
    public int checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @return 结果
     */
    public AppMember checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @return 结果
     */
    public AppMember checkEmailUnique(String email);

    /**
     * 更改用户余额
     */
    void updateMemberBalance(AppMemberBalancePram appMemberBalancePram);

    /**
     * 更改agent佣金xxxx
     *
     * @param
     * @param
     */
    void updateAgentMemberBalance(@Param("record") List<AppMember> record, @Param("goodsPrice") BigDecimal goodsPrice);

    /**
     * 查询会员agent
     */
    List<AppMember> selectAppMemberParentAgent(Long appMemberBalancePram);

    /**
     * 查询parent组
     */
    String selectParent();

    void updateAgentBalance(AppMemberBalancePram appMemberBalancePram);


}