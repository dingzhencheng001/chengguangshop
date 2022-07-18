package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppMemberAccountChange;
import my.fast.admin.app.entity.AppMemberAccountChangeExample;

public interface AppMemberAccountChangeMapper {
    long countByExample(AppMemberAccountChangeExample example);

    int deleteByExample(AppMemberAccountChangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberAccountChange record);

    int insertSelective(AppMemberAccountChange record);

    List<AppMemberAccountChange> selectByExample(AppMemberAccountChangeExample example);

    AppMemberAccountChange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMemberAccountChange record, @Param("example") AppMemberAccountChangeExample example);

    int updateByExample(@Param("record") AppMemberAccountChange record, @Param("example") AppMemberAccountChangeExample example);

    int updateByPrimaryKeySelective(AppMemberAccountChange record);

    int updateByPrimaryKey(AppMemberAccountChange record);

    List<AppMemberAccountChange> selectMemberAccountChange(@Param("type")Integer type, @Param("memberId")Long memberId);

    List<AppMemberAccountChange> getMemberList(Integer type, Long memberId);

}