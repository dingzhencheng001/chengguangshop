package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.google.protobuf.ServiceException;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppGoodsExample;
import my.fast.admin.cg.mapper.AppGoodsMapper;
import my.fast.admin.cg.model.AppGoodsParam;
import my.fast.admin.cg.model.GoodsParam;
import my.fast.admin.cg.service.GoodsService;
import my.fast.admin.framework.utils.DateFormat;

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
    public List<AppGoods> listGoods(GoodsParam goodsParam, Long channelId) {
        PageHelper.startPage(goodsParam.getPageNum(), goodsParam.getPageSize());
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        AppGoodsExample.Criteria criteria = appGoodsExample.createCriteria();
        String goodsName = goodsParam.getGoodsName();
        BigDecimal minPrice = goodsParam.getMinPrice();
        BigDecimal maxPrice = goodsParam.getMaxPrice();
        Long goodsSortId = goodsParam.getGoodsSortId();
        if (!StringUtils.isEmpty(goodsParam.getGoodsName())) {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (!StringUtils.isEmpty(minPrice) && !StringUtils.isEmpty(maxPrice)) {
            criteria.andGoodsPriceBetween(minPrice, maxPrice);
        }
        if (!StringUtils.isEmpty(goodsSortId)) {
            criteria.andGoodsSortIdEqualTo(goodsSortId);
        }
        criteria.andChannelIdEqualTo(channelId);
        return appGoodsMapper.selectByExample(appGoodsExample);
    }

    @Override
    public List<AppGoods> getGoods(Long channelId) {
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria().andChannelIdEqualTo(channelId);
        return appGoodsMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int importGoodsList(List<AppGoods> goodsList) {
         return appGoodsMapper.insertGoodsList(goodsList);
    }

    @Override
    public int deleteGoods(Long id) {
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andIdEqualTo(id);
        return appGoodsMapper.deleteByExample(appGoodsExample);
    }

    @Override
    public int createGoods(AppGoodsParam appGoodsParam, Long channelId) {
        //上架
        appGoodsParam.setStatus(1);
        //添加时间
        appGoodsParam.setGoodsAddTime(DateFormat.getNowDate());
        AppGoods appGoods = new AppGoods();
        BeanUtils.copyProperties(appGoodsParam, appGoods);
        appGoods.setChannelId(channelId);
        return appGoodsMapper.insertSelective(appGoods);
    }

    @Override
    public int updateGoods(Long id, AppGoods appGoods) {
        AppGoodsExample appGoodsExample = new AppGoodsExample();
        appGoodsExample.createCriteria()
            .andIdEqualTo(id);
        return appGoodsMapper.updateByExampleSelective(appGoods, appGoodsExample);

    }

    @Override
    public AppGoods selectById(Long id, Long channelId) {
        return appGoodsMapper.selectByGoodsId(id, channelId);
    }
}
