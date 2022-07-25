package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.entity.AppMemberAccountChangeExample;
import my.fast.admin.cg.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.cg.service.AppMemberAccountChangeService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppMemberAccountChangeServiceImpl implements AppMemberAccountChangeService {

    @Autowired
    private AppMemberAccountChangeMapper appMemberAccountChangeMapper;

    @Override
    public List<AppMemberAccountChange> listAll() {
        return appMemberAccountChangeMapper.selectByExample(new AppMemberAccountChangeExample());
    }

    @Override
    public List<AppMemberAccountChange> listAccountChange(Integer type, Long memberId, Integer pageNum,
        Integer pageSize) {

        List<AppMemberAccountChange> appMemberAccountChanges = appMemberAccountChangeMapper.selectMemberAccountChange(
            type, memberId);
        PageHelper.startPage(pageNum, pageSize);
        return appMemberAccountChanges;
    }

    @Override
    public List<AppMemberAccountChange> getMemberList(Integer pageNum, Integer pageSize,Long memberId) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberAccountChangeExample appMemberAccountChangeExample = new AppMemberAccountChangeExample();
        AppMemberAccountChangeExample.Criteria criteria = appMemberAccountChangeExample.createCriteria();
	    if (!StringUtils.isEmpty(memberId)) {
	        criteria.andMemberIdEqualTo(memberId);
	    }
        return appMemberAccountChangeMapper.selectByExample(appMemberAccountChangeExample);

    }

    @Override
    public int deleteAccountChangeById(Long id) {
        return appMemberAccountChangeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createAccountChange(AppMemberAccountChange appAccountChangeParam) {
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        BeanUtils.copyProperties(appAccountChangeParam, appMemberAccountChange);
        return appMemberAccountChangeMapper.insertSelective(appMemberAccountChange);
    }

    @Override
    public int updateAccountChange(Long id, AppMemberAccountChange appAccountChangeParam) {
        AppMemberAccountChange appMemberAccountChange = new AppMemberAccountChange();
        BeanUtils.copyProperties(appAccountChangeParam, appMemberAccountChange);
        appMemberAccountChange.setId(id);
        return appMemberAccountChangeMapper.updateByPrimaryKeySelective(appMemberAccountChange);

    }
}