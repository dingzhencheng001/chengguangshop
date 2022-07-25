package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppGoodsSort;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:38
 */
public interface AppGoodsSortService {

    /**
     * 获取所有商品分类
     */
    List<AppGoodsSort> listAll();

    /**
     * 分页查询商品分类
     */
    List<AppGoodsSort> listGoodsSort(AppGoodsSort appGoodsSort, Integer pageNum, Integer pageSize);

    /**
     * 删除商品分类
     */
    int deleteGoodsSort(Long id);

    /**
     * 创建商品分类
     */
    int createGoodsSort(AppGoodsSort appGoodsSort);

    /**
     * 修改商品分类
     */
    @Transactional
    int updateGoodsSort(Long id, AppGoodsSort appGoodsSort);
}
