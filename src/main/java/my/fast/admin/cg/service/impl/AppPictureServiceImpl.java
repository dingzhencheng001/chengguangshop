package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppPicture;
import my.fast.admin.cg.entity.AppPictureExample;
import my.fast.admin.cg.mapper.AppPictureMapper;
import my.fast.admin.cg.model.PictureParam;
import my.fast.admin.cg.service.AppPictureService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/25 16:36
 */
@Service
public class AppPictureServiceImpl implements AppPictureService {

    @Autowired
    private AppPictureMapper appPictureMapper;

    @Override
    public List<AppPicture> selectPicture(PictureParam pictureParam) {
        AppPictureExample appPictureExample = new AppPictureExample();
        appPictureExample.createCriteria()
            .andChannelIdEqualTo(pictureParam.getChannelId())
            .andPictureTypeEqualTo(pictureParam.getPictureType())
            .andShowTypeEqualTo(pictureParam.getShowType());
        return appPictureMapper.selectByExample(appPictureExample);
    }
}
