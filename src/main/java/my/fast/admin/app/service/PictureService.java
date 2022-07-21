package my.fast.admin.app.service;

import java.util.List;

import my.fast.admin.app.entity.AppPicture;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/21 11:41
 */
public interface PictureService {


    /**
     *  获取所有图片
     */
    List<AppPicture> listAll();

    /**
     *  分页查询
     */
    List<AppPicture> getPictureList(Integer pageNum, Integer pageSize);

    /**
     *  删除图片
     */
    int deletePictureById(Long id);
}
