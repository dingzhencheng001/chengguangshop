package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.CustomerCare;
import my.fast.admin.cg.model.CustomerCareParam;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:29
 */
public interface CustomerCareService {
    /**
     * 获取客服列表
     */
    List<CustomerCare> getCustomerCareList(CustomerCareParam param,Integer pageNum, Integer pageSize);

    /**
     * 删除客服
     */
    int deleteCustomerCare(Long id);

    /**
     * 编辑客服
     */
    int updateCustomerCare(Long id, CustomerCare customerCare);

    /**
     * 新增客服
     */
    int createCustomerCare(CustomerCare customerCare, Long channelId);




}
