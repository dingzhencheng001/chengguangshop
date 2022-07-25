package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.entity.SysChannelExample;

public interface SysChannelMapper {
    long countByExample(SysChannelExample example);

    int deleteByExample(SysChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysChannel record);

    int insertSelective(SysChannel record);

    List<SysChannel> selectByExample(SysChannelExample example);

    SysChannel selectByPrimaryKey(Long id);
    
    
    SysChannel getChannelInfoByAppDns(String appDns);

    int updateByExampleSelective(@Param("record") SysChannel record, @Param("example") SysChannelExample example);

    int updateByExample(@Param("record") SysChannel record, @Param("example") SysChannelExample example);

    int updateByPrimaryKeySelective(SysChannel record);

    int updateByPrimaryKey(SysChannel record);
}