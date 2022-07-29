package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.entity.SysOperateLogExample;

public interface SysOperateLogMapper {
    long countByExample(SysOperateLogExample example);

    int deleteByExample(SysOperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOperateLog record);

    int insertSelective(SysOperateLog record);

    List<SysOperateLog> selectByExample(SysOperateLogExample example);

    SysOperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    int updateByExample(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    int updateByPrimaryKeySelective(SysOperateLog record);

    int updateByPrimaryKey(SysOperateLog record);
}