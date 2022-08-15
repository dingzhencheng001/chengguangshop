package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppDispatchOrder;
import my.fast.admin.cg.model.DispatchOrderParam;
import my.fast.admin.cg.model.DispatchParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/30 14:07
 */
public interface DispatchOrderService {

    /**
     * 派单
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int assignGoods(List<DispatchOrderParam> dispatchOrderParam) throws Exception;

    /**
     * 获取当天派单列表
     */
    List<AppDispatchOrder> getOrderList(DispatchParam dispatchParam);

    /**
     * 商品价格校验
     */
    int checkPrice(DispatchOrderParam dispatchOrderParam) throws Exception;

    /**
     * 根据时间查询派单组次
     */
    List<Integer> findGroup(DispatchParam dispatchParam);

    /**
     * 校验是否有重复单据
     */
    int checkOrderQuantity(DispatchOrderParam dispatchOrderParam);

    /**
     * 查询列表最大值
     */
    int selectBigOrderNo(DispatchOrderParam dispatchOrderParam);
}
