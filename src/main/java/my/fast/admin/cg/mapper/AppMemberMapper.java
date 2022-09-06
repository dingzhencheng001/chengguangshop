package my.fast.admin.cg.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberExample;
import my.fast.admin.cg.model.AppMemberBalanceParam;
import my.fast.admin.cg.model.AppMemberParam;
import my.fast.admin.cg.model.AppTeamParam;
import my.fast.admin.cg.model.AppTeamReportInfo;
import my.fast.admin.cg.model.MemberParam;
import my.fast.admin.cg.model.MemberParams;
import my.fast.admin.cg.vo.AppMemberDto;
import my.fast.admin.cg.vo.AppMemberIncomeVo;
import my.fast.admin.cg.vo.AppMemberVo;
import my.fast.admin.cg.vo.AppTeamReportVo;

public interface AppMemberMapper {
    long countByExample(AppMemberExample example);

    int deleteByExample(AppMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMember record);

    int insertSelective(AppMember record);

    List<AppMember> selectByExample(AppMemberExample example);

    AppMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMember record, @Param("example") AppMemberExample example);

    int updateByExample(@Param("record") AppMember record, @Param("example") AppMemberExample example);

    int updateByPrimaryKeySelective(AppMember record);

    int updateByPrimaryKey(AppMember record);

    AppMember selectAppMemberByUserAccount(String userAccount);

    AppMember selectAppMemberByCode(String code);

    /**
     * 校验用户名称是否唯一
     *
     * @return 结果
     */
    public int checkUserNameUnique(AppMemberParam appMemberParam);

    /**
     * 校验手机号码是否唯一
     *
     * @return 结果
     */
    public AppMember checkPhoneUnique(AppMemberParam appMemberParam);

    /**
     * 手机号+ 渠道号 查询用户信息
     *
     * @return 结果
     */
    public AppMember selectAppMemberByUserPhone(AppMemberParam appMemberParam);

    /**
     * 校验email是否唯一
     *
     * @return 结果
     */
    public AppMember checkEmailUnique(String email);

    /**
     * 更改用户余额
     */
    void updateMemberBalance(AppMemberBalanceParam appMemberBalanceParam);

    /**
     * 查询会员agent
     */
    List<AppMember> selectAppMemberParentAgent(Long appMemberBalancePram);

    /**
     * 查询parent组
     */
    String selectParent();

    /**
     * 更新上级账户
     */
    void updateAgentBalance(AppMemberBalanceParam appMemberBalanceParam);

    /**
     * 获取会员账户信息
     *
     * @param id
     */
    AppMemberDto selectAppMemberCountByPrimary(Long id);

    /**
     * 获取下级会员信息
     *
     */
    List<AppMember> getMemberTeam(AppTeamParam appTeamParam);

    /**
     * 获取下级团队信息
     *
     * @param memberId ，level
     */
    List<AppMember> getTeamLevelList(@Param("memberId") Long memberId, @Param("param") MemberParam param);

    /**
     * 分页查询
     *
     * @param channelId
     * @param memberParams
     */
    List<AppMemberVo> selectPage(@Param("channelId") Long channelId, @Param("memberParams") MemberParams memberParams);

    /**
     * 根据会员id和渠号id查询
     *
     * @param channelId
     * @param memberId
     */
    AppMember selectMemberByIdAndChannelId(@Param("channelId") Long channelId, @Param("memberId") Long memberId);

    /**
     * 更改提现后的余额
     *
     * @param channelId
     * @param memberId
     * @param withdrawalNum
     */
    int updateBalance(@Param("channelId") Long channelId, @Param("memberId") Long memberId,
        @Param("withdrawalNum") BigDecimal withdrawalNum);

    /**
     * 审核通过后修改账户余额
     *
     * @param channelId
     * @param memberId
     * @param withdrawalNum
     */
    int changeBalance(@Param("channelId") Long channelId, @Param("memberId") Long memberId,
        @Param("withdrawalNum") BigDecimal withdrawalNum);


    /**
     * 审核不通过后修改账户余额
     *
     * @param channelId
     * @param memberId
     * @param withdrawalNum
     */
    int rollbackBalance(@Param("channelId") Long channelId, @Param("memberId") Long memberId,
        @Param("withdrawalNum") BigDecimal withdrawalNum);

    /**
     * 冻结用户佣金
     */
    int freezeBalance(AppMemberBalanceParam appMemberBalanceParam);

    /**
     * 冻结代理佣金
     * @param appMemberBalanceParam
     */
    void updateAgentGrabCommission(AppMemberBalanceParam appMemberBalanceParam);

    /**
     * 派单卡单上级佣金解冻
     */
    int updateBalanceByCommission(@Param("memberId")Long memberId, @Param("channelId")Long channelId, @Param("total")BigDecimal total);

    /**
     * 获取下级会员关键信息
     */
    List<AppTeamReportInfo> getAgentListInfo(AppTeamParam appTeamParam);

    /**
     * 按照会员等级获取下级信息
     */
    List<AppTeamReportInfo> getAgentListInfoByLevelId(AppTeamParam appTeamParam);

    /**
     * 获取抢单限制
     */
    int selectMemberLevel(@Param("memberId")Long memberId, @Param("channelId")Long channelId);

    /**
     * 获取会员收入信息
     */
    AppMemberIncomeVo selectMemberIncome(@Param("memberId")Long memberId, @Param("channelId")Long channelId);

    /**
     * 最后一单解冻
     */
    int unfreezeIndividualAccount(@Param("memberId")Long memberId, @Param("channelId")Long channelId, @Param("total")BigDecimal total, @Param("totalGoodsPrice")BigDecimal totalGoodsPrice);
    /**
     * 个人账户更新
     */
    int updateOwnAccount(@Param("memberId")Long memberId, @Param("channelId")Long channelId, @Param("goodsPrice")BigDecimal goodsPrice, @Param("grabCommission")BigDecimal grabCommission);
}