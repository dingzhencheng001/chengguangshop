package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.SysNotice;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:03
 */
public interface AppNoticeService {
    /**
     * 获取所有消息通知
     */
    List<SysNotice> listAllNotice();


    /**
     * 获取消息通知
     */
    List<SysNotice> getNoticeList(Integer pageNum, Integer pageSize);


    /**
     * 删除消息通知
     */
    int deleteNotice(Long id);

    /**
     * 更新消息通知
     */
    int updateNotice(Long id, SysNotice sysNotice);

    /**
     * 新增消息通知
     */
    int createNotice(SysNotice sysNotice);

    /**
     * 获取个人消息通知
     */
    List<SysNotice> getMemberNoticeList(Integer pageNum, Integer pageSize, Long memberId);
}
