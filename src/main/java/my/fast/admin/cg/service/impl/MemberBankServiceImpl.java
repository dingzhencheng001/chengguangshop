package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.AppMemberBankExample;
import my.fast.admin.cg.mapper.AppMemberBankMapper;
import my.fast.admin.cg.service.MemberBankService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 18:04
 */
@Service
public class MemberBankServiceImpl implements MemberBankService {

    @Autowired
    private AppMemberBankMapper appMemberBankMapper;

    @Override
    public List<AppMemberBank> listBanks(Integer pageNum, Integer pageSize, Long channelId) {
        AppMemberBankExample appMemberBankExample = new AppMemberBankExample();
        AppMemberBankExample.Criteria criteria = appMemberBankExample.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        return appMemberBankMapper.selectByExample(appMemberBankExample);
    }

    @Override
    public int deleteBanks(Long id, Long channelId) {
        AppMemberBankExample appMemberBankExample = new AppMemberBankExample();
        appMemberBankExample.createCriteria()
            .andIdEqualTo(id)
            .andChannelIdEqualTo(channelId);
        return appMemberBankMapper.deleteByExample(appMemberBankExample);
    }

    @Override
    public AppMemberBank getMemberBank(Long id, Long channelId) {
        return appMemberBankMapper.selectByMemberIdAndChannelId(id,channelId);
    }

    @Override
    public int updateBanks(AppMemberBank appMemberBank, Long channelId) {
        appMemberBank.setChannelId(channelId);
        return appMemberBankMapper.updateByPrimaryKeySelective(appMemberBank);
    }

    @Override
    public int createBanks(AppMemberBank appMemberBank, Long channelId) {
        appMemberBank.setChannelId(channelId);
        return appMemberBankMapper.insertSelective(appMemberBank);
    }

    @Override
    public AppMemberBank getMemberBank(Long userId) {
        return appMemberBankMapper.selectByMemberId(userId);
    }

}
