package my.fast.admin.cg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import my.fast.admin.cg.entity.CustomerCare;
import my.fast.admin.cg.entity.CustomerCareExample;
import my.fast.admin.cg.mapper.CustomerCareMapper;
import my.fast.admin.cg.model.CustomerCareParam;
import my.fast.admin.cg.service.CustomerCareService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:30
 */
@Service
public class CustomerCareServiceImpl implements CustomerCareService {

    @Autowired
    private CustomerCareMapper customerCareMapper;

    @Override
    public List<CustomerCare> getCustomerCareList(CustomerCareParam param,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CustomerCareExample custExample = new CustomerCareExample();
        custExample.createCriteria().andChannelIdEqualTo(param.getChannelId());
        return customerCareMapper.selectByExample(custExample);
    }

    @Override
    public int deleteCustomerCare(Long id) {
        return customerCareMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCustomerCare(Long id, CustomerCare customerCare) {
    	customerCare.setId(id);
        return customerCareMapper.updateByPrimaryKeySelective(customerCare);
    }

    @Override
    public int createCustomerCare(CustomerCare customerCare, Long channelId) {
    	customerCare.setStatus(0);
    	customerCare.setChannelId(channelId);
    	customerCare.setCreateBy("admin");
    	customerCare.setCreateTime(DateFormat.getNowDate());
    	customerCare.setUpdateBy("admin");
    	customerCare.setUpdateTime(DateFormat.getNowDate());
        return customerCareMapper.insertSelective(customerCare);
    }

}
