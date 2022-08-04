package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppControl;
import my.fast.admin.cg.entity.AppControlExample;
import my.fast.admin.cg.mapper.AppControlMapper;
import my.fast.admin.cg.service.ControlService;
/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/25 18:04
 */
@Service
public class ControlServiceImpl implements ControlService {

    @Autowired
    private AppControlMapper controlMapper;
    
    @Override
    public List<AppControl> listControl(Long channelId) {
    	AppControlExample appExample = new AppControlExample();
    	AppControlExample.Criteria criteria = appExample.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        return controlMapper.selectByExample(appExample);
    }

    @Override
    public int deleteControl(Long id, Long channelId) {
    	AppControlExample appExample = new AppControlExample();
    	appExample.createCriteria()
            .andIdEqualTo(id)
            .andChannelIdEqualTo(channelId);
        return controlMapper.deleteByExample(appExample);
    }

    @Override
    public int updateControl(AppControl control, Long channelId) {
    	control.setChannelId(channelId);
        return controlMapper.updateByPrimaryKeySelective(control);
    }

    @Override
    public int createControl(AppControl control, Long channelId) {
    	control.setChannelId(channelId);
        return controlMapper.insertSelective(control);
    }
  
    @Override
    public AppControl getControl(Long channelId) {
        return controlMapper.selectByChannelId(channelId);
    }
}
