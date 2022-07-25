package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.SysChannel;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
public interface AppChannelService {

    /**
     * 获取所有渠道信息
     */
    List<SysChannel> listAll();

    /**
     * 获取渠道列表
     */
    List<SysChannel> listChannelList(Integer pageNum, Integer pageSize);

    /**
     * 删除
     */
    int deleteChannel(Long id);

    /**
     * 更新
     */
    @Transactional
    int updateChannel(Long id, SysChannel sysChannel);

    /**
     * 新增
     */
    int createChannel(SysChannel sysChannel);
    
    
    /**
     * 根据请求的域名获取渠道信息
     */
    SysChannel getChannelInfoByAppDns(String appDns);
    
}
