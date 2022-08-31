package my.fast.admin.cg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.entity.SysNoticeExample;
import my.fast.admin.cg.mapper.SysNoticeMapper;
import my.fast.admin.cg.model.SysNoticeParam;
import my.fast.admin.cg.service.AppNoticeService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:06
 */
@Service
public class AppNoticeServiceImpl implements AppNoticeService {

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    @Override
    public List<SysNotice> getNoticeList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysNoticeExample sysNoticeExample = new SysNoticeExample();
        return sysNoticeMapper.selectByExample(sysNoticeExample);
    }

    @Override
    public int deleteNotice(Long id) {
        return sysNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateNotice(Long id, SysNotice sysNotice) {
        sysNotice.setId(id);
        return sysNoticeMapper.updateByPrimaryKeySelective(sysNotice);
    }

    @Override
    public int createNotice(SysNotice sysNotice) {
        return sysNoticeMapper.insertSelective(sysNotice);
    }

    @Override
    public List<SysNotice> getMemberNoticeList(SysNoticeParam sysNoticeParam) {
        PageHelper.startPage(sysNoticeParam.getPageNum(), sysNoticeParam.getPageSize());
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        SysNoticeExample sysNoticeExample = new SysNoticeExample();
        sysNoticeExample.createCriteria()
            .andStatusEqualTo("1")
            .andMemberIdEqualTo(sysNoticeParam.getMemberId())
            .andChannelIdEqualTo(sysNoticeParam.getChannelId())
            .andNoticeClassesIn(integers);
        return sysNoticeMapper.selectByExample(sysNoticeExample);
    }
}
