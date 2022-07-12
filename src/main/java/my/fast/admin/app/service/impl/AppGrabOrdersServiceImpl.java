package my.fast.admin.app.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.mapper.AppGoodsMapper;
import my.fast.admin.app.mapper.AppMemberMapper;
import my.fast.admin.app.model.AppRandomOrderPram;
import my.fast.admin.app.service.AppGrabOrdersService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 15:08
 */
@Service
public class AppGrabOrdersServiceImpl implements AppGrabOrdersService {

    @Autowired
    private AppGoodsMapper appGoodsMapper;

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Override
    public AppGoods randomOrders(AppRandomOrderPram appRandomOrderPram) throws Exception {
        Long memberId = appRandomOrderPram.getMemberId();
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        AppGoods appGoods = new AppGoods();
        if (StringUtils.isEmpty(appMember)) {
            throw new Exception("会员不存在");
        }
        if (!StringUtils.isEmpty(appMember)) {
            BigDecimal balance = appMember.getBalance();
            BigDecimal rate = new BigDecimal("0.5");
            BigDecimal useBalance = balance.multiply(rate);
            appGoods=appGoodsMapper.randomOrders(useBalance);
        }
        return appGoods;
    }
}
