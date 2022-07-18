package my.fast.admin.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import my.fast.admin.app.entity.SysAgentList;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
public interface AppAgentListService {

    /**
     * 获取所有代理佣金信息
     * 随机返回十条数据
     */
    List<SysAgentList> listAll();

    /**
     * 获取代理佣金信息列表
     */
    List<SysAgentList> listAgentList(Integer pageNum, Integer pageSize);

    /**
     * 删除
     */
    int deleteAgentList(Long id);

    /**
     * 更新
     */
    @Transactional
    int updateAgentList(Long id, SysAgentList sysAgentList);

    /**
     * 新增
     */
    int createAgentList(SysAgentList sysAgentList);
}
