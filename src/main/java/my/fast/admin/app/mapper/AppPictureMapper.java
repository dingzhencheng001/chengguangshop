package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppPicture;
import my.fast.admin.app.entity.AppPictureExample;

public interface AppPictureMapper {
    long countByExample(AppPictureExample example);

    int deleteByExample(AppPictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppPicture record);

    int insertSelective(AppPicture record);

    List<AppPicture> selectByExample(AppPictureExample example);

    AppPicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppPicture record, @Param("example") AppPictureExample example);

    int updateByExample(@Param("record") AppPicture record, @Param("example") AppPictureExample example);

    int updateByPrimaryKeySelective(AppPicture record);

    int updateByPrimaryKey(AppPicture record);
}