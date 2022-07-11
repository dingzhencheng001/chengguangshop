package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppConvey;
import my.fast.admin.app.entity.AppConveyExample;
import my.fast.admin.app.mapper.AppConveyMapper;
import my.fast.admin.app.service.AppConveyControllerService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppConveyControllerServiceImpl implements AppConveyControllerService {

    @Autowired
    private AppConveyMapper appConveyMapper;

    @Override
    public List<AppConvey> listAll() {
        return appConveyMapper.selectByExample(new AppConveyExample());
    }

    @Override
    public List<AppConvey> listConvey(AppConvey appConvey, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppConveyExample appGoodsExample = new AppConveyExample();
//        AppConveyExample.Criteria criteria = appGoodsExample.createCriteria();
//        if (!StringUtils.isEmpty(appConvey.get)) {
//            criteria.andGoodsNameLike("%" + goodsName + "%");
//        }
        
        return appConveyMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int deleteConveyById(Long id) {
        return appConveyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createConvey(AppConvey appConveyParam) {
    	AppConvey appConvey = new AppConvey();
        BeanUtils.copyProperties(appConveyParam, appConvey);
        return appConveyMapper.insertSelective(appConvey);
    }

    @Override
    public int updateConvey(Long id, AppConvey appConveyParam) {
    	AppConvey appConvey = new AppConvey();
        BeanUtils.copyProperties(appConveyParam, appConvey);
        appConvey.setId(id);
        return appConveyMapper.updateByPrimaryKeySelective(appConvey);

    }
}