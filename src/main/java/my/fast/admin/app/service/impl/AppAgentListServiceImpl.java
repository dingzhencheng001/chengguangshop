package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.SysAgentList;
import my.fast.admin.app.entity.SysAgentListExample;
import my.fast.admin.app.mapper.SysAgentListMapper;
import my.fast.admin.app.service.AppAgentListService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
@Service
public class AppAgentListServiceImpl implements AppAgentListService {

    @Autowired
    private SysAgentListMapper sysAgentListMapper;

    @Override
    public List<SysAgentList> listAll() {
        return sysAgentListMapper.selectByExample(new SysAgentListExample());
    }

    @Override
    public List<SysAgentList> listAgentList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysAgentListExample agentListExample = new SysAgentListExample();
        return sysAgentListMapper.selectByExample(agentListExample);
    }

    @Override
    public int deleteAgentList(Long id) {
        return sysAgentListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAgentList(Long id, SysAgentList sysAgentList) {
    	sysAgentList.setId(id);
        return sysAgentListMapper.updateByPrimaryKeySelective(sysAgentList);
    }

    @Override
    public int createAgentList(SysAgentList sysAgentList) {
        return sysAgentListMapper.insertSelective(sysAgentList);
    }
}
