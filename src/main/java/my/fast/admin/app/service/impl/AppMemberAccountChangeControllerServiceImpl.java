package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppMemberAccountChange;
import my.fast.admin.app.entity.AppMemberAccountChangeExample;
import my.fast.admin.app.mapper.AppMemberAccountChangeMapper;
import my.fast.admin.app.service.AppMemberAccountChangeControllerService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppMemberAccountChangeControllerServiceImpl implements AppMemberAccountChangeControllerService {

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