package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppPicture;
import my.fast.admin.cg.entity.AppPictureExample;
import my.fast.admin.cg.mapper.AppPictureMapper;
import my.fast.admin.cg.service.PictureService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/21 11:45
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private AppPictureMapper appPictureMapper;

    @Override
    public List<AppPicture> getPictureList(Integer pageNum, Integer pageSize, Long channelId) {
        PageHelper.startPage(pageNum, pageSize);
        AppPictureExample appPictureExample = new AppPictureExample();
        appPictureExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appPictureMapper.selectByExample(appPictureExample);
    }

    @Override
    public int deletePictureById(Long id) {
        return appPictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createPicture(AppPicture appPicture, Long channelId) {
        appPicture.setChannelId(channelId);
        appPicture.setUpdateTime(DateFormat.getNowDate());
        return appPictureMapper.insertSelective(appPicture);
    }

    @Override
    public int updatePicture(Long id, AppPicture appPicture) {
        appPicture.setId(id);
        appPicture.setUpdateTime(DateFormat.getNowDate());
        return appPictureMapper.updateByPrimaryKeySelective(appPicture);
    }

}
