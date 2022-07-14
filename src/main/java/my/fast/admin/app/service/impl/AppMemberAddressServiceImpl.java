package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.entity.AppMemberAddress;
import my.fast.admin.app.entity.AppMemberAddressExample;
import my.fast.admin.app.mapper.AppMemberAddressMapper;
import my.fast.admin.app.model.AppMemberAddressPram;
import my.fast.admin.app.service.AppMemberAddressService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:37
 */
@Service
public class AppMemberAddressServiceImpl implements AppMemberAddressService {


    @Autowired
    private AppMemberAddressMapper appMemberAddressMapper;

    @Override
    public List<AppMemberAddress> listAll() {
        return appMemberAddressMapper.selectByExample(new AppMemberAddressExample());
    }

    @Override
    public List<AppMemberAddress> listAddress(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberAddressExample appMemberLevelExample = new AppMemberAddressExample();
        return appMemberAddressMapper.selectByExample(appMemberLevelExample);
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
    public int createAddress(AppMemberAddressPram appMemberAddressPram) {
        AppMemberAddress appMemberAddress = new AppMemberAddress();
        BeanUtils.copyProperties(appMemberAddressPram, appMemberAddress);
        return appMemberAddressMapper.insertSelective(appMemberAddress);
    }

	@Override
	public AppMemberAddress getMemberAddress(Long userId) {
		
		return appMemberAddressMapper.selectBymemberId(userId);
	}
}
