package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.AppPicture;
import my.fast.admin.cg.model.PictureParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/25 16:31
 */
public interface AppPictureService {

    /**
     * 获取app图片展示列表
     * @param pictureParam
     */
    List<AppPicture> selectPicture(PictureParam pictureParam);


}
