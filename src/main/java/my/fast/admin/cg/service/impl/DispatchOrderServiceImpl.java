package my.fast.admin.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import my.fast.admin.cg.model.DispatchParam;
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
        //先判断是新增还是修改
        //修改需删除后随机生成
        //新增直接新增
        AppAssignGoods appAssignGoods = new AppAssignGoods();
        AppDispatchOrder appDispatchOrder = new AppDispatchOrder();
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            //根据价格范围随机生成商品
            AppGoods appGoods = appGoodsMapper.randomGoodsByExample(orderParam);
            if(!StringUtils.isEmpty(appGoods)){
                String orderSn = generateOrderSn();
                BeanUtils.copyProperties(appGoods, appAssignGoods);
                appAssignGoods.setHinder(orderParam.getHinder());
                appAssignGoods.setGoodsAddTime(DateFormat.getNowDate());
                appAssignGoods.setMemberId(orderParam.getMemberId());
                appAssignGoods.setSerialNumber(orderSn);
                //插入派单商品库
                appAssignGoodsMapper.insert(appAssignGoods);
                //先入派单业务表库
                BeanUtils.copyProperties(orderParam, appDispatchOrder);
                appDispatchOrder.setCreateTime(DateFormat.getNowDate());
                appDispatchOrder.setSerialNumber(orderSn);
                appDispatchOrderMapper.insert(appDispatchOrder);
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

    @Override
    public int checkPrice(DispatchOrderParam dispatchOrderParam) throws Exception {
            //生成随机商品
            AppGoods appGoods = appGoodsMapper.randomGoodsByExample(dispatchOrderParam);
            //如果为空则报错
            if(StringUtils.isEmpty(appGoods)){
                throw new Exception("指派商品价格在商品库不存在,请重新输入价格范围!");
            }
            return 1;
    }

    @Override
    public List<AppDispatchOrder> findGroup(DispatchParam dispatchParam) {
        return appDispatchOrderMapper.findGroup(dispatchParam);
    }

    /**
     * 生成订单编号
     */
    public String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("PD");
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        sb.append(date);
        int num = 0;
        for (int i = 0; i < 5000; i++) {
            num = (int) ((Math.random() * 9 + 1) * 100000);
        }
        String num_str = String.valueOf(num);
        sb.append(num_str);
        return sb.toString();
    }

}
