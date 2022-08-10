package my.fast.admin.cg.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.model.AppRandomOrderParam;

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
    Object randomOrders(AppRandomOrderParam appRandomOrderParam) throws Exception;
    /**
     * 提交随机生成的商品订单
     */
    @Transactional
    int submitOrders(Object appGoods, Long memberId, Long channelId ) throws Exception;
}
