package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.model.MemberAddressParam;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:32
 */
public interface MemberAddressService {
   
    /**
     * 获取会员地址信息列表
     */
    List<AppMemberAddress> listAddress(MemberAddressParam  param,Integer pageNum, Integer pageSize);
    /**
     * 删除会员地址
     */
    int deleteAddress(Long id);
    /**
     * 更新会员地址
     */
   @Transactional(rollbackFor = Exception.class)
    int updateAddress(AppMemberAddress appMemberAddress);
   
   /**
    * 新增会员地址
    * @param 
    */
   int createAddress(AppMemberAddress appMemberAddress);
   
    
    /**
     * 查询会员地址信息
     */
    AppMemberAddress getMemberAddress(Long userId);
    
    
    /**
     * 查询会员地址信息
     */
    AppMemberAddress getMemberAddress(Long memberId, Long channelId);
    
    
}
