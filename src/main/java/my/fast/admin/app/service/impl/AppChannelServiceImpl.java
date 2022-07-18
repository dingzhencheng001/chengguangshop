package my.fast.admin.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.app.entity.SysChannel;
import my.fast.admin.app.entity.SysChannelExample;
import my.fast.admin.app.mapper.SysChannelMapper;
import my.fast.admin.app.service.AppChannelService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
@Service
public class AppChannelServiceImpl implements AppChannelService {

    @Autowired
    private SysChannelMapper sysChannelMapper;

    @Override
    public List<SysChannel> listAll() {
        return sysChannelMapper.selectByExample(new SysChannelExample());
    }

    @Override
    public List<SysChannel> listChannelList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysChannelExample channelExample = new SysChannelExample();
        return sysChannelMapper.selectByExample(channelExample);
    }

    @Override
    public int deleteChannel(Long id) {
        return sysChannelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateChannel(Long id, SysChannel sysChannel) {
    	sysChannel.setId(id);
        return sysChannelMapper.updateByPrimaryKeySelective(sysChannel);
    }

    @Override
    public int createChannel(SysChannel sysChannel) {
        return sysChannelMapper.insertSelective(sysChannel);
    }

	@Override
	public SysChannel getChannelInfoByAppDns(String appDns) {
		return sysChannelMapper.getChannelInfoByAppDns(appDns);
	}
}
