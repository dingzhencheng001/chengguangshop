package my.fast.admin.app.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.AppMemberExample;
import my.fast.admin.app.mapper.AppMemberMapper;
import my.fast.admin.app.service.AppMemberControllerService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppMemberControllerServiceImpl implements AppMemberControllerService {

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Override
    public List<AppMember> listAll() {
        return appMemberMapper.selectByExample(new AppMemberExample());
    }

    @Override
    public List<AppMember> listMember(AppMember appMember, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberExample appMemberExample = new AppMemberExample();
        AppMemberExample.Criteria criteria = appMemberExample.createCriteria();
        if (!StringUtils.isEmpty(appMember.getStatus().toString())) {
            criteria.equals(appMember.getStatus());
        }
        if (!StringUtils.isEmpty(appMember.getUserAccount())) {
            criteria.andUserAccountLike("%" + appMember.getUserAccount() + "%");
        }
        if (!StringUtils.isEmpty(appMember.getPhoneNumber())) {
            criteria.andPhoneNumberLike("%" + appMember.getPhoneNumber() + "%");
        }
        if (!StringUtils.isEmpty(appMember.getNickName())) {
            criteria.andNickNameLike("%" + appMember.getNickName() + "%");
        }
        return appMemberMapper.selectByExample(appMemberExample);
    }

    @Override
    public int deleteMemberById(Long id) {
        return appMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createMember(AppMember appMemberParam) {
    	AppMember appMember = new AppMember();
        BeanUtils.copyProperties(appMemberParam, appMember);
        return appMemberMapper.insertSelective(appMember);
    }

    @Override
    public int updateMember(Long id, AppMember appMemberParam) {
    	AppMember appMember = new AppMember();
        BeanUtils.copyProperties(appMemberParam, appMember);
        appMember.setId(id);
        return appMemberMapper.updateByPrimaryKeySelective(appMember);

    }
}