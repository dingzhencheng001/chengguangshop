package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.entity.AppMemberAddressExample;

public interface AppMemberAddressMapper {
    long countByExample(AppMemberAddressExample example);

    int deleteByExample(AppMemberAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberAddress record);

    int insertSelective(AppMemberAddress record);

    List<AppMemberAddress> selectByExample(AppMemberAddressExample example);

    AppMemberAddress selectByPrimaryKey(Long id);
    
    AppMemberAddress selectByMemberId(@Param("memberId")Long memberId);

    int updateByExampleSelective(@Param("record") AppMemberAddress record, @Param("example") AppMemberAddressExample example);

    int updateByExample(@Param("record") AppMemberAddress record, @Param("example") AppMemberAddressExample example);

    int updateByPrimaryKeySelective(AppMemberAddress record);

    int updateByPrimaryKey(AppMemberAddress record);
    
    
    /***************************************************************/
    List<AppMemberAddress> selectAddressByExample(AppMemberAddressExample example);
    

    AppMemberAddress selectByMemberIdAndChannelId(@Param("memberId")Long memberId, @Param("channelId")Long channelId);
    
}