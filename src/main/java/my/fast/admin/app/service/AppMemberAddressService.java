package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.app.entity.AppMemberAddress;
import my.fast.admin.app.entity.AppMemberBank;
import my.fast.admin.app.model.AppMemberAddressPram;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:32
 */
public interface AppMemberAddressService {
    /**
     * 获取所有会员地址信息
     */
    List<AppMemberAddress> listAll();
    /**
     * 获取会员地址信息列表
     */
    List<AppMemberAddress> listAddress(Integer pageNum, Integer pageSize);
    /**
     * 删除会员地址
     */
    int deleteAddress(Long id);
    /**
     * 更新会员地址
     */
   @Transactional
    int updateAddress(AppMemberAddress appMemberAddress);
    /**
     * 新增会员地址
     * @param appMemberAddressPram
     */
    int createAddress(AppMemberAddressPram appMemberAddressPram);
    
    
    /**
     * 查询会员地址信息
     */
    AppMemberAddress getMemberAddress(Long userId);
    
    
}
