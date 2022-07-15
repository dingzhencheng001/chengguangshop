package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.SysChannel;
import my.fast.admin.app.entity.SysChannelExample;

public interface SysChannelMapper {
    long countByExample(SysChannelExample example);

    int deleteByExample(SysChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysChannel record);

    int insertSelective(SysChannel record);

    List<SysChannel> selectByExample(SysChannelExample example);

    SysChannel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysChannel record, @Param("example") SysChannelExample example);

    int updateByExample(@Param("record") SysChannel record, @Param("example") SysChannelExample example);

    int updateByPrimaryKeySelective(SysChannel record);

    int updateByPrimaryKey(SysChannel record);
}