package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppPicture;
import my.fast.admin.cg.entity.AppPictureExample;

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

    AppPicture selectPictureById(@Param("channelId")Long channelId, @Param("id")Long id);
}