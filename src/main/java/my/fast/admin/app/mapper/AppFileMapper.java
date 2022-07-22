package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppFile;
import my.fast.admin.app.entity.AppFileExample;

public interface AppFileMapper {
    long countByExample(AppFileExample example);

    int deleteByExample(AppFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppFile record);

    int insertSelective(AppFile record);

    List<AppFile> selectByExample(AppFileExample example);

    AppFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppFile record, @Param("example") AppFileExample example);

    int updateByExample(@Param("record") AppFile record, @Param("example") AppFileExample example);

    int updateByPrimaryKeySelective(AppFile record);

    int updateByPrimaryKey(AppFile record);
}