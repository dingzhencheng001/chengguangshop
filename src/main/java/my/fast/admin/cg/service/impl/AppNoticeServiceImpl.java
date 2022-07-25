package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.entity.SysNoticeExample;
import my.fast.admin.cg.mapper.SysNoticeMapper;
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
    public List<SysNotice> listAllNotice() {
        return sysNoticeMapper.selectByExample(new SysNoticeExample());
    }

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
        sysNotice.setNoticeId(id);
        return sysNoticeMapper.updateByPrimaryKeySelective(sysNotice);
    }

    @Override
    public int createNotice(SysNotice sysNotice) {
        return sysNoticeMapper.insertSelective(sysNotice);
    }

    @Override
    public List<SysNotice> getMemberNoticeList(Integer pageNum, Integer pageSize, Long memberId) {
        PageHelper.startPage(pageNum, pageSize);
        return sysNoticeMapper.getMemberNoticeList(memberId);
    }
}
