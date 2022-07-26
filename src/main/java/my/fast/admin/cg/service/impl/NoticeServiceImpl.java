package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.entity.SysNoticeExample;
import my.fast.admin.cg.mapper.SysNoticeMapper;
import my.fast.admin.cg.service.NoticeService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:30
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    @Override
    public List<SysNotice> getNoticeList(Integer pageNum, Integer pageSize, Long channelId) {
        PageHelper.startPage(pageNum, pageSize);
        SysNoticeExample sysNoticeExample = new SysNoticeExample();
        sysNoticeExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return sysNoticeMapper.selectByExample(sysNoticeExample);
    }

    @Override
    public int deleteNotice(Long id) {
        return sysNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateNotice(Long id, SysNotice sysNotice) {
        sysNotice.setNoticeId(id);
        return sysNoticeMapper.updateByPrimaryKeySelective(sysNotice);
    }

    @Override
    public int createNotice(SysNotice sysNotice, Long channelId) {
        sysNotice.setChannelId(channelId);
        return sysNoticeMapper.insertSelective(sysNotice);
    }

}
