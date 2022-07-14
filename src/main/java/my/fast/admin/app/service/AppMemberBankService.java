package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.app.entity.AppMemberBank;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:15
 */
public interface AppMemberBankService {

    /**
     * 获取所有银行卡信息
     */
    List<AppMemberBank> listAll();

    /**
     * 获取所有银行卡信息列表
     */
    List<AppMemberBank> listBanks(Integer pageNum, Integer pageSize);

    /**
     * 删除会员银行卡信息
     */
    int deleteBanks(Long id);

    /**
     * 更新会员银行卡信息
     */
    @Transactional
    int updateBanks(AppMemberBank appMemberBank);


    /**
     * 新增会员银行卡信息
     */
    int createBanks(AppMemberBank appMemberBank);
    
    
    /**
     * 查询会员银行卡信息
     */
    AppMemberBank getMemberBank(Long userId);
    
}
