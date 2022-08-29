package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.service.AppMemberDepositService;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.AppMemberDepositExample;
import my.fast.admin.cg.mapper.AppMemberDepositMapper;
import my.fast.admin.cg.model.ListDepositParam;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/29 16:01
 */
@Service
public class AppMemberDepositServiceImpl implements AppMemberDepositService {

    @Autowired
    private AppMemberDepositMapper depositMapper;


    @Override
    public List<AppMemberDeposit> listDeposit(ListDepositParam deposit, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberDepositExample listExample = new AppMemberDepositExample();
        AppMemberDepositExample.Criteria criteria = listExample.createCriteria();
        criteria.andChannelIdEqualTo(deposit.getChannelId());
        if (!StringUtils.isEmpty(deposit.getOrderNo())) {
            criteria.andOrderNoEqualTo(deposit.getOrderNo());
        }
        if (!StringUtils.isEmpty(deposit.getUserAccount())) {
            criteria.andUserAccountEqualTo(deposit.getUserAccount());
        }
        if (!StringUtils.isEmpty(deposit.getPhoneNumber())) {
            criteria.andPhoneNumberEqualTo(deposit.getPhoneNumber());
        }
        if (!StringUtils.isEmpty(deposit.getSelectBeginTime())) {
            criteria.andCreateTimeBetween(deposit.getSelectBeginTime(), deposit.getSelectEndTime());
        }
        return depositMapper.selectByExample(listExample);
    }
}
