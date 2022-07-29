package my.fast.admin.cg.service;

import java.util.List;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.model.OperateLogParam;
/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 10:29
 */
public interface OperateLogService {
    /**
     * 获取操作日志
     */
    List<SysOperateLog> getOperateLogList(Integer pageNum, Integer pageSize, OperateLogParam param);

    /**
     * 新增操作日志
     */
    int createOperateLog(SysOperateLog sysOperateLog);




}
