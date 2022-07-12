package my.fast.admin.app.service;

import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.model.AppRandomOrderPram;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 15:05
 */
public interface AppGrabOrdersService {

    AppGoods randomOrders(AppRandomOrderPram appRandomOrderPram) throws Exception;
}
