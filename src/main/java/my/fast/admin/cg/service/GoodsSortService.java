package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppGoodsSort;
import my.fast.admin.cg.model.GoodsSortParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:38
 */
public interface GoodsSortService {

    /**
     * 获取所有商品分类
     */
    List<AppGoodsSort> listAll();

    /**
     * 删除商品分类
     */
    int deleteGoodsSort(Long id);

    /**
     * 创建商品分类
     */
    int createGoodsSort(AppGoodsSort appGoodsSort, Long channelId);

    /**
     * 修改商品分类
     */
    @Transactional(rollbackFor = Exception.class)
    int updateGoodsSort(Long id, AppGoodsSort appGoodsSort);

    /**
     * 分页查询商品分类
     */
    List<AppGoodsSort> listGoodsSort(GoodsSortParam goodsSortParam, Long channelId);

    /**
     * 分页id查询商品分类信息
     */
    AppGoodsSort selectById(Long id);
}
