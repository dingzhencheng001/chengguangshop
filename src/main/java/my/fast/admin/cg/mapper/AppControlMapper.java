package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppControl;
import my.fast.admin.cg.entity.AppControlExample;

public interface AppControlMapper {
    long countByExample(AppControlExample example);

    int deleteByExample(AppControlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppControl record);

    int insertSelective(AppControl record);

    List<AppControl> selectByExample(AppControlExample example);

    AppControl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppControl record, @Param("example") AppControlExample example);

    int updateByExample(@Param("record") AppControl record, @Param("example") AppControlExample example);

    int updateByPrimaryKeySelective(AppControl record);

    int updateByPrimaryKey(AppControl record);
}