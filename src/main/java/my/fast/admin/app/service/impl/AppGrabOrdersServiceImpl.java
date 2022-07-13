package my.fast.admin.app.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.fast.admin.app.entity.AppConvey;
import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.AppMemberAccountChange;
import my.fast.admin.app.entity.AppMemberLevel;
import my.fast.admin.app.mapper.AppConveyMapper;
import my.fast.admin.app.mapper.AppGoodsMapper;
import my.fast.admin.app.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.app.mapper.AppMemberLevelMapper;
import my.fast.admin.app.mapper.AppMemberMapper;
import my.fast.admin.app.model.AppMemberBalancePram;
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

    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Autowired
    private AppMemberLevelMapper appMemberLevelMapper;

    @Autowired
    private AppConveyMapper appConveyMapper;


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
            appGoods = appGoodsMapper.randomOrders(useBalance);
        }
        return appGoods;
    }

    @Override
    public int submitOrders(AppGoods appGoods, Long memberId) {
        AppConvey appConvey = new AppConvey();
        //获取会员信息
        AppMember appMember = appMemberMapper.selectByPrimaryKey(memberId);
        BigDecimal goodsPrice = appGoods.getGoodsPrice();
        BigDecimal balance = appMember.getBalance();
        //获取会员等级
        AppMemberLevel appMemberLevel = appMemberLevelMapper.selectByPrimaryKey(appMember.getMemberLevelId());
        BigDecimal commission = appMemberLevel.getCommission();
        //佣金计算
        BigDecimal GrabCommission = goodsPrice.multiply(commission);
        appConvey.setCommission(GrabCommission);
        //生成订单号
        appConvey.setLno(generateOrderSn());
        //修改本单金额
        appConvey.setAmount(appGoods.getGoodsPrice());
        //修改下单时间
        appConvey.setAddtime(appGoods.getGoodsAddTime());
        //增加抢单数
        appConvey.setQiang(1L);
        //修改会员余额金额
        //appMember.setBalance(balance.subtract(goodsPrice).add(GrabCommission));
        AppMemberBalancePram appMemberBalancePram = new AppMemberBalancePram();
        appMemberBalancePram.setMemberId(memberId);
        appMemberBalancePram.setGoodsPrice(goodsPrice);
        appMemberBalancePram.setBalance(appMember.getBalance());
        appMemberBalancePram.setGrabCommission(GrabCommission);
        appMemberMapper.updateMemberBalance(appMemberBalancePram);
        //插入账目变动表信息
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        appMemberAccountChange.setMemberId(memberId);
        appMemberAccountChange.setOperaType(2);
        appMemberAccountChange.setPreOperaMount(appMember.getBalance());
        appMemberAccountChange.setOperaMount(goodsPrice);
        //获取更新后的金额
        AppMember appMemberOpera = appMemberMapper.selectByPrimaryKey(memberId);
        appMemberAccountChange.setTotalMount(appMemberOpera.getBalance());
        appMemberAccountChange.setCreateBy(appMemberOpera.getRealName());
        Date date = new Date(System.currentTimeMillis());
        appMemberAccountChange.setCreateTime(date);
        appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
        return appConveyMapper.insertSelective(appConvey);
    }

    /**
     * 生成订单编号
     */
    private String generateOrderSn() {
        StringBuilder sb = new StringBuilder();
        sb.append("UB");
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
