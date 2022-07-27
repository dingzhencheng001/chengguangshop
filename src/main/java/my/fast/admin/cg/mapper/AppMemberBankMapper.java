package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.AppMemberBankExample;

public interface AppMemberBankMapper {
    long countByExample(AppMemberBankExample example);

    int deleteByExample(AppMemberBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberBank record);

    int insertSelective(AppMemberBank record);

    List<AppMemberBank> selectByExample(AppMemberBankExample example);

    AppMemberBank selectByPrimaryKey(Integer id);
    
    AppMemberBank selectByMemberId(@Param("memberId")Long memberId);

    int updateByExampleSelective(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByExample(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByPrimaryKeySelective(AppMemberBank record);

    int updateByPrimaryKey(AppMemberBank record);

    AppMemberBank selectByMemberIdAndChannelId(@Param("memberId")Long memberId, @Param("channelId")Long channelId);
}