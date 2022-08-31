package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.entity.SysNoticeExample;
import my.fast.admin.cg.model.SysNoticeParam;

public interface SysNoticeMapper {
    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int deleteByPrimaryKey(Long noticeId);

    int insert(SysNotice row);

    int insertSelective(SysNotice row);

    List<SysNotice> selectByExample(SysNoticeExample example);

    SysNotice selectByPrimaryKey(Long noticeId);

    int updateByExampleSelective(@Param("row") SysNotice row, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("row") SysNotice row, @Param("example") SysNoticeExample example);

    int updateByPrimaryKeySelective(SysNotice row);

    int updateByPrimaryKey(SysNotice row);

    List<SysNotice> selectMemberNotice(SysNoticeParam sysNoticeParam);
}