package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.entity.AppMemberLevelExample;
import my.fast.admin.cg.mapper.AppMemberLevelMapper;
import my.fast.admin.cg.service.AppMemberLevelService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:34
 */
@Service
public class AppMemberLevelServiceImpl implements AppMemberLevelService {

    @Autowired
    private AppMemberLevelMapper appMemberLevelMapper;

    @Override
    public List<AppMemberLevel> listAll() {
        return appMemberLevelMapper.selectByExample(new AppMemberLevelExample());
    }

    @Override
    public List<AppMemberLevel> listLevels(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AppMemberLevelExample appMemberLevelExample = new AppMemberLevelExample();
        return appMemberLevelMapper.selectByExample(appMemberLevelExample);
    }

    @Override
    public int deleteLevels(Long id) {
        return appMemberLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateLevels(Long id, AppMemberLevel appMemberLevel) {
        appMemberLevel.setId(id);
        return appMemberLevelMapper.updateByPrimaryKeySelective(appMemberLevel);
    }

    @Override
    public int createLevels(AppMemberLevel appMemberLevel) {
        return appMemberLevelMapper.insertSelective(appMemberLevel);
    }

    @Override
    public int selectMemberLevel(Long memberLevelId, Long channelId) {
        return appMemberLevelMapper.selectMemberOrderLimit();

    }
}
