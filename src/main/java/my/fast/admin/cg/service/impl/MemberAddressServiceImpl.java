package my.fast.admin.cg.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.entity.AppMemberAddressExample;
import my.fast.admin.cg.entity.AppMemberExample;
import my.fast.admin.cg.mapper.AppMemberAddressMapper;
import my.fast.admin.cg.model.AppMemberAddressPram;
import my.fast.admin.cg.model.MemberAddressParam;
import my.fast.admin.cg.service.MemberAddressService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:37
 */
@Service
public class MemberAddressServiceImpl implements MemberAddressService {


    @Autowired
    private AppMemberAddressMapper appMemberAddressMapper;

  

    @Override
    public List<AppMemberAddress> listAddress(MemberAddressParam  param,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberAddressExample appMemberLevelExample = new AppMemberAddressExample();
        
        AppMemberAddressExample.Criteria criteria = appMemberLevelExample.createCriteria();
        criteria.andChannelIdEqualTo(param.getChannelId());//查询范围为 当前渠道数据
        
        return appMemberAddressMapper.selectAddressByExample(appMemberLevelExample);
    }

    @Override
    public int deleteAddress(Long id) {
        return appMemberAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAddress(AppMemberAddress appMemberAddress) {
        return appMemberAddressMapper.updateByPrimaryKeySelective(appMemberAddress);
    }


	@Override
	public AppMemberAddress getMemberAddress(Long userId) {
		return appMemberAddressMapper.selectByMemberId(userId);
	}

	@Override
	public int createAddress(AppMemberAddress appMemberAddress) {
		return appMemberAddressMapper.insertSelective(appMemberAddress);
	}
}
