package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.entity.SysOperateLogExample;
import my.fast.admin.cg.mapper.SysOperateLogMapper;
import my.fast.admin.cg.model.OperateLogParam;
import my.fast.admin.cg.service.OperateLogService;
import my.fast.admin.framework.utils.DateFormat;
/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:30
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private SysOperateLogMapper sysOperateLogMapper;

    @Override
    public List<SysOperateLog> getOperateLogList(Integer pageNum, Integer pageSize, OperateLogParam param) {
        PageHelper.startPage(pageNum, pageSize);
        SysOperateLogExample sysOperateLogExample = new SysOperateLogExample();
        SysOperateLogExample.Criteria criteria = sysOperateLogExample.createCriteria();
        criteria.andChannelIdEqualTo(param.getChannelId());
        if (!StringUtils.isEmpty(param.getTitle())) {
        	criteria.andTitleLike("%" + param.getTitle() + "%");
        }
        if (!StringUtils.isEmpty(param.getOperateContent())) {
        	criteria.andOperateContentLike("%" + param.getOperateContent() + "%");
        }
        if (!StringUtils.isEmpty(param.getSelectBeginTime())) {
            criteria.andCreateTimeBetween(param.getSelectBeginTime(), param.getSelectEndTime());
        }
        
        return sysOperateLogMapper.selectByExample(sysOperateLogExample);
    }

    @Override
    public int createOperateLog(SysOperateLog sysOperateLog) {
    	sysOperateLog.setCreateTime(DateFormat.getNowDate());
        if(StringUtils.isEmpty(sysOperateLog.getCreateBy())){
        	sysOperateLog.setCreateBy("admin");
        }
        return sysOperateLogMapper.insertSelective(sysOperateLog);
    }

}
