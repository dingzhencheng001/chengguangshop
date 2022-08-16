package my.fast.admin.cg.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.model.AppGoodsParam;
import my.fast.admin.cg.model.GoodsParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 12:02
 */
public interface GoodsService {

    /**
     * 删除商品
     */
    int deleteGoods(Long id);

    /**
     * 创建品牌
     */
    int createGoods(AppGoodsParam appGoodsParam, Long channelId);

    /**
     * 修改品牌
     */
    @Transactional(rollbackFor = Exception.class)
    int updateGoods(Long id, AppGoods appGoods);

    /**
     * 根据id查询
     */
    AppGoods selectById(Long id, Long channelId);

    /**
     * 分页查询
     */
    List<AppGoods> listGoods(GoodsParam goodsParam, Long channelId);

    /**
     * 获取所有商品信息
     */
    List<AppGoods> getGoods(Long channelId);

    /**
     * 导入商品列表
     */
    int importGoodsList(List<AppGoods> goodsList);

}
