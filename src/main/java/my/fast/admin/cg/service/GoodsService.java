package my.fast.admin.cg.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.model.AppGoodsParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 12:02
 */
public interface GoodsService {

    /**
     * 分页查询品牌
     * @param goodsName
     * @param pageNum
     * @param pageSize
     * @param minPrice
     * @param maxPrice
     * @param channelId
     */
    List<AppGoods> listGoods(String goodsName, Integer pageNum, Integer pageSize, BigDecimal minPrice,
        BigDecimal maxPrice, Long channelId);

    /**
     * 删除商品
     */
    int deleteGoods(Long id, Long channelId);

    /**
     * 创建品牌
     */
    int createGoods(AppGoodsParam appGoodsParam, Long channelId);

    /**
     * 修改品牌
     */
    @Transactional
    int updateGoods(Long id, AppGoods appGoods, Long channelId);

    /**
     * 根据id查询
     */
    AppGoods selectById(Long id, Long channelId);
}
