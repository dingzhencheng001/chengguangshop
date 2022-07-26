package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.model.MemberDepositParam;
import my.fast.admin.cg.vo.AppConveyDto;

/**
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 11:50
 */
public interface MemberDepositService {


    /**
     * 分页查询充值订单
     */
    List<AppMemberDeposit> listDeposit(AppMemberDeposit deposit, Integer pageNum, Integer pageSize);

    /**
     * 删除充值订单
     */
    int deleteDepositById(Long id);

    /**
     * 会员充值
     */
    @Transactional
    int createDeposit(MemberDepositParam depositParam);



}
