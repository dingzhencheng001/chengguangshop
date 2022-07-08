package com.macro.mall.mapper;

import com.macro.mall.model.AppMemberBank;
import com.macro.mall.model.AppMemberBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMemberBankMapper {
    long countByExample(AppMemberBankExample example);

    int deleteByExample(AppMemberBankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppMemberBank record);

    int insertSelective(AppMemberBank record);

    List<AppMemberBank> selectByExample(AppMemberBankExample example);

    AppMemberBank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByExample(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByPrimaryKeySelective(AppMemberBank record);

    int updateByPrimaryKey(AppMemberBank record);
}