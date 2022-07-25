package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberOrder;
import my.fast.admin.cg.entity.AppMemberOrderExample;

public interface AppMemberOrderMapper {
    long countByExample(AppMemberOrderExample example);

    int deleteByExample(AppMemberOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(AppMemberOrder record);

    int insertSelective(AppMemberOrder record);

    List<AppMemberOrder> selectByExample(AppMemberOrderExample example);

    AppMemberOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppMemberOrder record, @Param("example") AppMemberOrderExample example);

    int updateByExample(@Param("record") AppMemberOrder record, @Param("example") AppMemberOrderExample example);

    int updateByPrimaryKeySelective(AppMemberOrder record);

    int updateByPrimaryKey(AppMemberOrder record);
}