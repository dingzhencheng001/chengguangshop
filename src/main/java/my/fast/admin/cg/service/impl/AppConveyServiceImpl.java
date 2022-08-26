package my.fast.admin.cg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppConveyExample;
import my.fast.admin.cg.mapper.AppConveyMapper;
import my.fast.admin.cg.model.AppConveyParam;
import my.fast.admin.cg.service.AppConveyService;
import my.fast.admin.cg.vo.AppConveyVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class AppConveyServiceImpl implements AppConveyService {

    @Autowired
    private AppConveyMapper appConveyMapper;

    @Override
    public List<AppConvey> listAll() {
        return appConveyMapper.selectByExample(new AppConveyExample());
    }

    @Override
    public List<AppConveyVo> listConvey(AppConveyParam appConveyParam) {
        PageHelper.startPage(appConveyParam.getPageNum(), appConveyParam.getPageSize());
        List<AppConveyVo> appConveyVoArrayList = new ArrayList<>();
        List<AppConvey> appConveys = appConveyMapper.selectByExample(new AppConveyExample());
        List<Integer> collect = appConveys.stream()
            .map(e -> e.getConveyType())
            .distinct()
            .collect(Collectors.toList());
        for (Integer integer : collect) {
            if (integer == 1) {
                List<AppConveyVo> appConveyVoList = appConveyMapper.selectConveyInfo(appConveyParam);
                appConveyVoArrayList.addAll(appConveyVoList);
            }
            if (integer == 2) {
                List<AppConveyVo> appConveyVoList = appConveyMapper.selectConveyInfoByPd(appConveyParam);
                appConveyVoArrayList.addAll(appConveyVoList);
            }
        }
        return appConveyVoArrayList;
    }

    @Override
    public int deleteConveyById(Long id) {
        return appConveyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createConvey(AppConvey appConveyParam) {
        AppConvey appConvey = new AppConvey();
        BeanUtils.copyProperties(appConveyParam, appConvey);
        return appConveyMapper.insertSelective(appConvey);
    }

    @Override
    public int updateConvey(Long id, AppConvey appConveyParam) {
        AppConvey appConvey = new AppConvey();
        BeanUtils.copyProperties(appConveyParam, appConvey);
        appConvey.setId(id);
        return appConveyMapper.updateByPrimaryKeySelective(appConvey);

    }
}