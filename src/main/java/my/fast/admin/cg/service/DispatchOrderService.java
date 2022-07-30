package my.fast.admin.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.model.DispatchOrderParam;

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
    @Transactional
    int assignGoods(List<DispatchOrderParam> dispatchOrderParam) throws Exception;

}
