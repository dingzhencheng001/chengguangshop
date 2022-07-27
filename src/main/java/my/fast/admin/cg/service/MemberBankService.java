package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppMemberBank;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 17:51
 */

public interface MemberBankService {

    /**
     * 分页查询
     */
    List<AppMemberBank> listBanks(Integer pageNum, Integer pageSize, Long channelId);
    /**
     * 删除银行卡信息
     */
    int deleteBanks(Long id, Long channelId);

    /**
     * 获取会员银行卡信息
     */
    AppMemberBank getMemberBank(Long memberId, Long channelId);



    /**
     * 更新会员银行卡信息
     */
    @Transactional
    int updateBanks(AppMemberBank appMemberBank, Long channelId);


    /**
     * 新增会员银行卡信息
     */
    int createBanks(AppMemberBank appMemberBank, Long channelId);


    /**
     * 查询会员银行卡信息
     */
    AppMemberBank getMemberBank(Long userId);

}
