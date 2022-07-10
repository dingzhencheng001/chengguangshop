package my.fast.admin.app.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.entity.AppGoodsExample;
import my.fast.admin.app.mapper.AppGoodsMapper;
import my.fast.admin.app.model.AppGoodsParam;
import my.fast.admin.app.service.AppGoodsControllerService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppGoodsControllerServiceImpl implements AppGoodsControllerService {

    @Autowired
    private AppGoodsMapper appGoodsMapper;

    @Override
    public List<AppGoods> listAll() {
        return appGoodsMapper.selectByExample(new AppGoodsExample());
    }

    @Override
    public List<AppGoods> listBrand(String goodsName, Integer pageNum, Integer pageSize, BigDecimal minPrice,
        BigDecimal maxPrice) {
        PageHelper.startPage(pageNum, pageSize);
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        AppGoodsExample.Criteria criteria = appGoodsExample.createCriteria();
        if (!StringUtils.isEmpty(goodsName)) {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (!StringUtils.isEmpty(minPrice) && !StringUtils.isEmpty(maxPrice)) {
            criteria.andGoodsPriceBetween(minPrice, maxPrice);
        }
        return appGoodsMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int deleteBrand(Long id) {
        return appGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createBrand(AppGoodsParam appGoodsParam) {
        AppGoods appGoods = new AppGoods();
        BeanUtils.copyProperties(appGoodsParam, appGoods);
        return appGoodsMapper.insertSelective(appGoods);
    }

    @Override
    public int updateBrand(Long id, AppGoodsParam appGoodsParam) {
        AppGoods appGoods = new AppGoods();
        BeanUtils.copyProperties(appGoodsParam, appGoods);
        appGoods.setId(id);
        return appGoodsMapper.updateByPrimaryKeySelective(appGoods);

    }
}