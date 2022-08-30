package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.entity.AppMemberLevelExample;

public interface AppMemberLevelMapper {
    long countByExample(AppMemberLevelExample example);

    int deleteByExample(AppMemberLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberLevel row);

    int insertSelective(AppMemberLevel row);

    List<AppMemberLevel> selectByExample(AppMemberLevelExample example);

    AppMemberLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") AppMemberLevel row, @Param("example") AppMemberLevelExample example);

    int updateByExample(@Param("row") AppMemberLevel row, @Param("example") AppMemberLevelExample example);

    int updateByPrimaryKeySelective(AppMemberLevel row);

    int updateByPrimaryKey(AppMemberLevel row);
}