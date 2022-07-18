package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.SysAgentList;
import my.fast.admin.app.entity.SysAgentListExample;

public interface SysAgentListMapper {
    long countByExample(SysAgentListExample example);

    int deleteByExample(SysAgentListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAgentList record);

    int insertSelective(SysAgentList record);

    List<SysAgentList> selectByExample(SysAgentListExample example);

    SysAgentList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAgentList record, @Param("example") SysAgentListExample example);

    int updateByExample(@Param("record") SysAgentList record, @Param("example") SysAgentListExample example);

    int updateByPrimaryKeySelective(SysAgentList record);

    int updateByPrimaryKey(SysAgentList record);
}