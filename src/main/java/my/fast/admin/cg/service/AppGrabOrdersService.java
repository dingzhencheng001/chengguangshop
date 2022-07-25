package my.fast.admin.cg.service;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.model.AppRandomOrderPram;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 15:05
 */
public interface AppGrabOrdersService {

    /**
     * 随机生成商品订单
     */
    AppGoods randomOrders(AppRandomOrderPram appRandomOrderPram) throws Exception;
    /**
     * 提交随机生成的商品订单
     */
    @Transactional
    int submitOrders(AppGoods appGoods, Long memberId) throws Exception;
}
