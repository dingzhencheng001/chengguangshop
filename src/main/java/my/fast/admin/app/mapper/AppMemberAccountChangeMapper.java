package com.macro.mall.mapper;

import com.macro.mall.model.AppMemberAccountChange;
import com.macro.mall.model.AppMemberAccountChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}