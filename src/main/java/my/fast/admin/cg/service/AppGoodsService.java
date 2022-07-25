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
 * @since 2022/7/10 10:38
 */
public interface AppGoodsService {

    /**
     * 获取所有商品
     */
    List<AppGoods> listAll();

    /**
     * 分页查询品牌
     */
    List<AppGoods> listGoods(String goodsName, Integer pageNum, Integer pageSize, BigDecimal minPrice,
        BigDecimal maxPrice);

    /**
     * 删除商品
     */
    int deleteGoods(Long id);

    /**
     * 创建品牌
     */
    int createGoods(AppGoodsParam appGoodsParam);

    /**
     * 修改品牌
     */
    @Transactional
    int updateGoods(Long id, AppGoodsParam appGoodsParam);
}
