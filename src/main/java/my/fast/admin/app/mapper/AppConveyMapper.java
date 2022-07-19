package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppConvey;
import my.fast.admin.app.entity.AppConveyExample;

public interface AppConveyMapper {
    long countByExample(AppConveyExample example);

    int deleteByExample(AppConveyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppConvey record);

    int insertSelective(AppConvey record);

    List<AppConvey> selectByExample(AppConveyExample example);

    AppConvey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppConvey record, @Param("example") AppConveyExample example);

    int updateByExample(@Param("record") AppConvey record, @Param("example") AppConveyExample example);

    int updateByPrimaryKeySelective(AppConvey record);

    int updateByPrimaryKey(AppConvey record);

    List<AppConvey>  selectConvey();
}