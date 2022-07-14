package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppMemberBank;
import my.fast.admin.app.entity.AppMemberBankExample;

public interface AppMemberBankMapper {
    long countByExample(AppMemberBankExample example);

    int deleteByExample(AppMemberBankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberBank record);

    int insertSelective(AppMemberBank record);

    List<AppMemberBank> selectByExample(AppMemberBankExample example);

    AppMemberBank selectByPrimaryKey(Integer id);
    
    AppMemberBank selectBymemberId(Long id);

    int updateByExampleSelective(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByExample(@Param("record") AppMemberBank record, @Param("example") AppMemberBankExample example);

    int updateByPrimaryKeySelective(AppMemberBank record);

    int updateByPrimaryKey(AppMemberBank record);
}