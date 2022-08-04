package my.fast.admin.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import my.fast.admin.cg.entity.AppControl;

/**
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 17:51
 */

public interface ControlService {

    /**
     * 查询
     */
    List<AppControl> listControl( Long channelId);
    /**
     * 删除交易控制信息
     */
    int deleteControl(Long id, Long channelId);

    /**
     * 更新交易控制信息
     */
    @Transactional
    int updateControl(AppControl control, Long channelId);

    /**
     * 新增当前渠道交易控制信息
     */
    int createControl(AppControl control, Long channelId);

    /**
     * 获取交易控制信息
     */
    AppControl getControl(Long channelId);

}
