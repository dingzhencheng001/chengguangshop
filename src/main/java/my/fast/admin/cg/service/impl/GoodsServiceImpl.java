package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppGoodsExample;
import my.fast.admin.cg.mapper.AppGoodsMapper;
import my.fast.admin.cg.model.AppGoodsParam;
import my.fast.admin.cg.service.GoodsService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 12:04
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private AppGoodsMapper appGoodsMapper;

    @Override
    public List<AppGoods> listAll(Long channelId) {
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appGoodsMapper.selectByExample(appGoodsExample);
    }

    @Override
    public List<AppGoods> listGoods(String goodsName, Integer pageNum, Integer pageSize, BigDecimal minPrice,
        BigDecimal maxPrice, Long channelId) {
        PageHelper.startPage(pageNum, pageSize);
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        AppGoodsExample.Criteria criteria = appGoodsExample.createCriteria();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        if (!StringUtils.isEmpty(goodsName)) {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (!StringUtils.isEmpty(minPrice) && !StringUtils.isEmpty(maxPrice)) {
            criteria.andGoodsPriceBetween(minPrice, maxPrice);
        }
        return appGoodsMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int deleteGoods(Long id, Long channelId) {
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createGoods(AppGoodsParam appGoodsParam, Long channelId) {
        AppGoods appGoods = new AppGoods();
        BeanUtils.copyProperties(appGoodsParam, appGoods);
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appGoodsMapper.insertSelective(appGoods);
    }

    @Override
    public int updateGoods(Long id, AppGoodsParam appGoodsParam, Long channelId) {
        AppGoods appGoods = new AppGoods();
        BeanUtils.copyProperties(appGoodsParam, appGoods);
        appGoods.setId(id);
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appGoodsMapper.updateByExampleSelective(appGoods,appGoodsExample);

    }
}
