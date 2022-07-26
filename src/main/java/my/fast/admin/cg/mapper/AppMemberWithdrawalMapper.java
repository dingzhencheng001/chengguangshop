package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.entity.AppMemberWithdrawalExample;
import my.fast.admin.cg.model.MemberWithdrawalPram;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;

public interface AppMemberWithdrawalMapper {
    long countByExample(AppMemberWithdrawalExample example);

    int deleteByExample(AppMemberWithdrawalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberWithdrawal record);

    int insertSelective(AppMemberWithdrawal record);

    List<AppMemberWithdrawal> selectByExample(AppMemberWithdrawalExample example);

    AppMemberWithdrawal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMemberWithdrawal record, @Param("example") AppMemberWithdrawalExample example);

    int updateByExample(@Param("record") AppMemberWithdrawal record, @Param("example") AppMemberWithdrawalExample example);

    int updateByPrimaryKeySelective(AppMemberWithdrawal record);

    int updateByPrimaryKey(AppMemberWithdrawal record);

    List<AppMemberWithdrawalVo> selectWithdrawalList(@Param("channelId") Long channelId,@Param("record")
        MemberWithdrawalPram record);

}