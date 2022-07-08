package com.macro.mall.mapper;

import com.macro.mall.model.AppMemberLevel;
import com.macro.mall.model.AppMemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMemberLevelMapper {
    long countByExample(AppMemberLevelExample example);

    int deleteByExample(AppMemberLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberLevel record);

    int insertSelective(AppMemberLevel record);

    List<AppMemberLevel> selectByExampleWithBLOBs(AppMemberLevelExample example);

    List<AppMemberLevel> selectByExample(AppMemberLevelExample example);

    AppMemberLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMemberLevel record, @Param("example") AppMemberLevelExample example);

    int updateByExampleWithBLOBs(@Param("record") AppMemberLevel record, @Param("example") AppMemberLevelExample example);

    int updateByExample(@Param("record") AppMemberLevel record, @Param("example") AppMemberLevelExample example);

    int updateByPrimaryKeySelective(AppMemberLevel record);

    int updateByPrimaryKeyWithBLOBs(AppMemberLevel record);

    int updateByPrimaryKey(AppMemberLevel record);
}