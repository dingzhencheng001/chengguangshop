package my.fast.admin.app.service;

import java.util.List;

import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.model.ListDepositParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/29 15:59
 */
public interface AppMemberDepositService {
    /**
     * 分页查询充值订单
     */
    List<AppMemberDeposit> listDeposit(ListDepositParam deposit, Integer pageNum, Integer pageSize);
}
