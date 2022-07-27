package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberWithdrawal;
import my.fast.admin.cg.entity.AppMemberWithdrawalExample;
import my.fast.admin.cg.mapper.AppMemberBankMapper;
import my.fast.admin.cg.mapper.AppMemberWithdrawalMapper;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.service.MemberWithdrawalService;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 16:01
 */
@Service
public class MemberWithdrawalServiceImpl implements MemberWithdrawalService {

    @Autowired
    private AppMemberWithdrawalMapper appMemberWithdrawalMapper;

    @Autowired
    private AppMemberBankMapper appMemberBankMapper;


    @Override
    public int approval(List<Long> ids, Integer status) {
        AppMemberWithdrawal record = new AppMemberWithdrawal();
        record.setIsDelete(status);
        AppMemberWithdrawalExample example = new AppMemberWithdrawalExample();
        example.createCriteria()
            .andIdIn(ids);
        return appMemberWithdrawalMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int rejectById(Long id, String remark) {
        AppMemberWithdrawal record = new AppMemberWithdrawal();
        record.setRemark(remark);
        AppMemberWithdrawalExample example = new AppMemberWithdrawalExample();
        example.createCriteria()
            .andIdEqualTo(id);
        return appMemberWithdrawalMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<AppMemberWithdrawalVo> findPage(Integer pageNum, Integer pageSize, Long channelId,
        MemberWithdrawalParam memberWithdrawalParam) {
        PageHelper.startPage(pageNum, pageSize);
        /*AppMemberWithdrawalExample appMemberWithdrawalExample = new AppMemberWithdrawalExample();
        AppMemberWithdrawalExample.Criteria criteria = appMemberWithdrawalExample.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        if (!StringUtils.isEmpty(memberWithdrawalPram.getOrderNo())) {
            criteria.andOrderNoLike("%" + memberWithdrawalPram.getOrderNo() + "%");
        }
        if (!StringUtils.isEmpty(memberWithdrawalPram.getUserAccount())) {
            criteria.andUserAccountLike("%" + memberWithdrawalPram.getUserAccount() + "%");
        }
        if (!StringUtils.isEmpty(memberWithdrawalPram.getSelectBeginTime())) {
            criteria.andCreateTimeBetween(memberWithdrawalPram.getSelectBeginTime(),
                memberWithdrawalPram.getSelectEndTime());
        }*/
       /* List<AppMemberWithdrawal> appMemberWithdrawalList = appMemberWithdrawalMapper.selectByExample(
            appMemberWithdrawalExample);
        for (AppMemberWithdrawal appMemberWithdrawal : appMemberWithdrawalList) {
            AppMemberBank appMemberBank = appMemberBankMapper.selectByMemberId(appMemberWithdrawal.getMemberId());
        }*/
        return appMemberWithdrawalMapper.selectWithdrawalList(channelId, memberWithdrawalParam);
    }
}
