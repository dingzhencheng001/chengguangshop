package com.macro.mall.mapper;

import com.macro.mall.model.AppMember;
import com.macro.mall.model.AppMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}