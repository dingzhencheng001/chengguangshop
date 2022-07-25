package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.AppMemberBankExample;
import my.fast.admin.cg.mapper.AppMemberBankMapper;
import my.fast.admin.cg.service.AppMemberBankService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:18
 */
@Service
public class AppMemberBankServiceImpl implements AppMemberBankService {

    @Autowired
    private AppMemberBankMapper appMemberBankMapper;

    @Override
    public List<AppMemberBank> listAll() {
        return appMemberBankMapper.selectByExample(new AppMemberBankExample());
    }

    @Override
    public List<AppMemberBank> listBanks(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        AppMemberBankExample appMemberBankExample = new AppMemberBankExample();
        return appMemberBankMapper.selectByExample(appMemberBankExample);
    }

    @Override
    public int deleteBanks(Long id) {
        return appMemberBankMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBanks(AppMemberBank appMemberBank) {
        return appMemberBankMapper.updateByPrimaryKeySelective(appMemberBank);
    }

    @Override
    public int createBanks(AppMemberBank appMemberBank) {
        return appMemberBankMapper.insertSelective(appMemberBank);
    }

	@Override
	public AppMemberBank getMemberBank(Long userId) {
		return appMemberBankMapper.selectByMemberId(userId);
	}
}
