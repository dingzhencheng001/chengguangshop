package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.entity.AppDispatchOrder;
import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.mapper.AppAssignGoodsMapper;
import my.fast.admin.cg.mapper.AppDispatchOrderMapper;
import my.fast.admin.cg.mapper.AppGoodsMapper;
import my.fast.admin.cg.model.DispatchOrderParam;
import my.fast.admin.cg.service.DispatchOrderService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/30 14:08
 */
@Service
public class DispatchOrderServiceImpl implements DispatchOrderService {

    @Autowired
    private AppGoodsMapper appGoodsMapper;

    @Autowired
    private AppAssignGoodsMapper appAssignGoodsMapper;

    @Autowired
    private AppDispatchOrderMapper appDispatchOrderMapper;


    @Override
    public int assignGoods(List<DispatchOrderParam> dispatchOrderParam) throws Exception {
        //先入派单业务表库
        AppDispatchOrder appDispatchOrder = new AppDispatchOrder();
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            BeanUtils.copyProperties(orderParam, appDispatchOrder);
            appDispatchOrder.setCreateTime(DateFormat.getNowDate());
            appDispatchOrderMapper.insert(appDispatchOrder);
        }
        AppAssignGoods appAssignGoods = new AppAssignGoods();
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            //根据价格范围随机生成商品
            AppGoods appGoods = appGoodsMapper.randomGoodsByExample(orderParam);
            if(!StringUtils.isEmpty(appGoods)){
                BeanUtils.copyProperties(appGoods, appAssignGoods);
                appAssignGoods.setHinder(orderParam.getHinder());
                appAssignGoods.setGoodsAddTime(DateFormat.getNowDate());
                appAssignGoods.setMemberId(orderParam.getMemberId());
                //插入派单商品库
                appAssignGoodsMapper.insert(appAssignGoods);
            }else {
                throw new Exception("指派商品价格在商品库不存在,请重新输入价格范围!");
            }
        }
        return 1;
    }

    @Override
    public List<AppDispatchOrder> getOrderList(Long channelId, Long memberId) {
        return appDispatchOrderMapper.selectOrderList(channelId,memberId);
    }

}
