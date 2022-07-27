package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberAccountChangeExample;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.model.AccountChangeParam;
import my.fast.admin.cg.service.MemberAccountChangeService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 15:15
 */
@Service
public class MemberAccountChangeServiceImpl implements MemberAccountChangeService {

    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Override
    public List<AppMemberAccountChange> getMemberList(Integer pageNum, Integer pageSize, Long channelId, Long memberId,
        AccountChangeParam accountChangeParam) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberAccountChangeExample appMemberAccountChangeExample = new AppMemberAccountChangeExample();
        AppMemberAccountChangeExample.Criteria criteria = appMemberAccountChangeExample.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        criteria.andMemberIdEqualTo(memberId);
        if (!StringUtils.isEmpty(accountChangeParam.getOperaType())) {
            criteria.andOperaTypeEqualTo(accountChangeParam.getOperaType());
        }
        if (!StringUtils.isEmpty(accountChangeParam.getSelectBeginTime())) {
            criteria.andCreateTimeBetween(accountChangeParam.getSelectBeginTime(),accountChangeParam.getSelectEndTime());
        }
        return appMemberAccountChangeMapper.selectByExample(appMemberAccountChangeExample);

    }

    @Override
    public int deleteAccountChangeById(Long id, Long channelId) {

        AppMemberAccountChangeExample appMemberAccountChangeExample = new AppMemberAccountChangeExample();
        appMemberAccountChangeExample.createCriteria()
            .andIdEqualTo(id)
            .andChannelIdEqualTo(channelId);
        return appMemberAccountChangeMapper.deleteByExample(appMemberAccountChangeExample);
    }

    @Override
    public int updateAccountChange(Long id, AppMemberAccountChange appMemberAccountChange, Long channelId) {

        AppMemberAccountChangeExample appMemberAccountChangeExample = new AppMemberAccountChangeExample();
        appMemberAccountChangeExample.createCriteria()
            .andChannelIdEqualTo(channelId)
            .andIdEqualTo(id);
        return appMemberAccountChangeMapper.updateByExampleSelective(appMemberAccountChange,
            appMemberAccountChangeExample);
    }

    @Override
    public int createAccountChange(AppMemberAccountChange appMemberAccountChange, Long channelId) {
        appMemberAccountChange.setChannelId(channelId);
        return appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
    }
}
