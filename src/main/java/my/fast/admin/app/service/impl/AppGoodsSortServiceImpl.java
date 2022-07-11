package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppGoodsSort;
import my.fast.admin.app.entity.AppGoodsSortExample;
import my.fast.admin.app.mapper.AppGoodsSortMapper;
import my.fast.admin.app.service.AppGoodsSortService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppGoodsSortServiceImpl implements AppGoodsSortService {

    @Autowired
    private AppGoodsSortMapper appGoodsSortMapper;

    @Override
    public List<AppGoodsSort> listAll() {
        return appGoodsSortMapper.selectByExample(new AppGoodsSortExample());
    }

    @Override
    public List<AppGoodsSort> listGoodsSort(AppGoodsSort appGoodsSort, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppGoodsSortExample appGoodsExample = new AppGoodsSortExample();
//        AppGoodsExample.Criteria criteria = appGoodsExample.createCriteria();
//        if (!StringUtils.isEmpty(goodsName)) {
//            criteria.andGoodsNameLike("%" + goodsName + "%");
//        }
        
        return appGoodsSortMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int deleteGoodsSort(Long id) {
        return appGoodsSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createGoodsSort(AppGoodsSort appGoodsSortParam) {
    	AppGoodsSort appGoods = new AppGoodsSort();
        BeanUtils.copyProperties(appGoodsSortParam, appGoods);
        return appGoodsSortMapper.insertSelective(appGoods);
    }

    @Override
    public int updateGoodsSort(Long id, AppGoodsSort appGoodsSortParam) {
    	AppGoodsSort appGoods = new AppGoodsSort();
        BeanUtils.copyProperties(appGoodsSortParam, appGoods);
        appGoods.setId(id);
        return appGoodsSortMapper.updateByPrimaryKeySelective(appGoods);

    }
}