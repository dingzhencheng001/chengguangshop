package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppPicture;
import my.fast.admin.app.entity.AppPictureExample;
import my.fast.admin.app.mapper.AppPictureMapper;
import my.fast.admin.app.service.PictureService;

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
    public List<AppPicture> listAll() {
        return appPictureMapper.selectByExample(new AppPictureExample());
    }

    @Override
    public List<AppPicture> getPictureList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return appPictureMapper.selectByExample(new AppPictureExample());
    }

    @Override
    public int deletePictureById(Long id) {
        return appPictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createPicture(AppPicture appPicture) {
        return appPictureMapper.insertSelective(appPicture);
    }

    @Override
    public int updatePicture(Long id, AppPicture appPicture) {
        appPicture.setId(id);
        return appPictureMapper.updateByPrimaryKeySelective(appPicture);
    }

}
