package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.AppPicture;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/21 11:41
 */
public interface PictureService {


    /**
     *  分页查询
     */
    List<AppPicture> getPictureList(Integer pageNum, Integer pageSize, Long channelId);

    /**
     *  删除图片
     */
    int deletePictureById(Long id);
    /**
     *  新增图片信息
     */
    int createPicture(AppPicture appPicture, Long channelId);

    /**
     *  修改图片信息
     */
    int updatePicture(Long id, AppPicture appPicture);

}
