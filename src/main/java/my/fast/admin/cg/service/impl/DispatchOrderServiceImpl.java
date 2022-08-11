package my.fast.admin.cg.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.entity.AppDispatchOrder;
import my.fast.admin.cg.entity.AppDispatchOrderExample;
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
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            Integer flag = orderParam.getIsConsumed();
            String serialNumber = orderParam.getSerialNumber();
            if (!"".equals(serialNumber)) {
                //删除的商品
                appAssignGoodsMapper.deleteAssignGoods(flag, serialNumber);
                //删除列表
                AppDispatchOrderExample appDispatchOrderExample = new AppDispatchOrderExample();
                appDispatchOrderExample.createCriteria()
                    .andSerialNumberEqualTo(orderParam.getSerialNumber());
                appDispatchOrderMapper.deleteByExample(appDispatchOrderExample);
                //修改商品
                return updateOrders(dispatchOrderParam);
            }
        }
        //生成商品
        return makeOrders(dispatchOrderParam);

    }

    public int makeOrders(List<DispatchOrderParam> dispatchOrderParam) throws Exception {
        AppAssignGoods appAssignGoods = new AppAssignGoods();
        AppDispatchOrder appDispatchOrder = new AppDispatchOrder();
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            //根据价格范围随机生成商品
            AppGoods appGoods = appGoodsMapper.randomGoodsByExample(orderParam);
            if (!StringUtils.isEmpty(appGoods)) {
                String orderSn = generateOrderSn();
                BeanUtils.copyProperties(appGoods, appAssignGoods);
                appAssignGoods.setHinder(orderParam.getHinder());
                appAssignGoods.setGoodsAddTime(orderParam.getCreateTime());
                appAssignGoods.setMemberId(orderParam.getMemberId());
                appAssignGoods.setSerialNumber(orderSn);
                appAssignGoods.setIsConsumed(0);
                appAssignGoods.setOrderQuantity(orderParam.getOrderQuantity());
                appAssignGoods.setWhichGroup(orderParam.getWhichGroup());
                appAssignGoods.setGoodsFlag(1);
                //先插入派单商品库
                appAssignGoodsMapper.insert(appAssignGoods);
                //后插入派单业务表库
                BeanUtils.copyProperties(orderParam, appDispatchOrder);
                appDispatchOrder.setCreateTime(orderParam.getCreateTime());
                appDispatchOrder.setSerialNumber(orderSn);
                appDispatchOrder.setOrderStatus(0);
                appDispatchOrderMapper.insert(appDispatchOrder);
            } else {
                throw new Exception("指派商品价格在商品库不存在,请重新输入价格范围!");
            }
        }
        return 1;
    }


    public int updateOrders(List<DispatchOrderParam> dispatchOrderParam) throws Exception {
        AppAssignGoods appAssignGoods = new AppAssignGoods();
        AppDispatchOrder appDispatchOrder = new AppDispatchOrder();
        for (DispatchOrderParam orderParam : dispatchOrderParam) {
            //根据价格范围随机生成商品
            AppGoods appGoods = appGoodsMapper.randomGoodsByExample(orderParam);
            if (!StringUtils.isEmpty(appGoods)) {
                String orderSn = generateOrderSn();
                BeanUtils.copyProperties(appGoods, appAssignGoods);
                appAssignGoods.setHinder(orderParam.getHinder());
                appAssignGoods.setGoodsAddTime(orderParam.getCreateTime());
                appAssignGoods.setMemberId(orderParam.getMemberId());
                appAssignGoods.setSerialNumber(orderSn);
                appAssignGoods.setIsConsumed(0);
                appAssignGoods.setOrderQuantity(orderParam.getOrderQuantity());
                appAssignGoods.setWhichGroup(orderParam.getWhichGroup());
                //先插入派单商品库
                appAssignGoodsMapper.insert(appAssignGoods);
                //后插入派单业务表库
                BeanUtils.copyProperties(orderParam, appDispatchOrder);
                appDispatchOrder.setCreateTime(orderParam.getCreateTime());
                appDispatchOrder.setSerialNumber(orderSn);
                appDispatchOrder.setOrderStatus(0);
                appDispatchOrderMapper.insert(appDispatchOrder);
            } else {
                throw new Exception("指派商品价格在商品库不存在,请重新输入价格范围!");
            }
        }
        return 1;
    }

    @Override
    public List<AppDispatchOrder> getOrderList(DispatchParam dispatchParam) {
        PageHelper.startPage(dispatchParam.getPageNum(), dispatchParam.getPageSize());

        return appDispatchOrderMapper.selectOrderList(dispatchParam);
    }

    @Override
    public int checkPrice(DispatchOrderParam dispatchOrderParam) throws Exception {
        //生成随机商品
        AppGoods appGoods = appGoodsMapper.randomGoodsByExample(dispatchOrderParam);
        //如果为空则报错
        if (StringUtils.isEmpty(appGoods)) {
            throw new Exception("指派商品价格在商品库不存在,请重新输入价格范围!");
        }
        return 1;
    }

    @Override
    public List<Integer> findGroup(DispatchParam dispatchParam) {
        List<AppDispatchOrder> group = appDispatchOrderMapper.findGroup(dispatchParam);
        List<Integer> groupList = new ArrayList<>();
        for (AppDispatchOrder appDispatchOrder : group) {
            Integer whichGroup = appDispatchOrder.getWhichGroup();
            groupList.add(whichGroup);
        }
        // 新集合
        List<Integer> newList = new ArrayList<>(groupList.size());
        groupList.forEach(i -> {
            if (!newList.contains(i)) {
                // 如果新集合中不存在则插入
                newList.add(i);
            }
        });
        return newList;

    }

    @Override
    public int checkOrderQuantity(DispatchOrderParam dispatchOrderParam) {
        return appDispatchOrderMapper.checkOrderQuantity(dispatchOrderParam);

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
