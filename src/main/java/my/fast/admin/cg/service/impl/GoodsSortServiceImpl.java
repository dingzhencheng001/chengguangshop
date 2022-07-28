package my.fast.admin.cg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import my.fast.admin.cg.entity.AppGoodsSort;
import my.fast.admin.cg.entity.AppGoodsSortExample;
import my.fast.admin.cg.mapper.AppGoodsSortMapper;
import my.fast.admin.cg.model.GoodsSortParam;
import my.fast.admin.cg.service.GoodsSortService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:40
 */
@Service
public class GoodsSortServiceImpl implements GoodsSortService {

    @Autowired
    private AppGoodsSortMapper appGoodsSortMapper;

    @Override
    public List<AppGoodsSort> listAll() {
        return appGoodsSortMapper.selectByExample(new AppGoodsSortExample());
    }

    @Override
    public List<AppGoodsSort> listGoodsSort(GoodsSortParam goodsSortParam, Long channelId) {
        PageHelper.startPage(goodsSortParam.getPageNum(), goodsSortParam.getPageSize());
        AppGoodsSortExample appGoodsExample = new AppGoodsSortExample();
        appGoodsExample.createCriteria()
            .andChannelIdEqualTo(channelId);
        return appGoodsSortMapper.selectByExample(appGoodsExample);
    }

    @Override
    public int deleteGoodsSort(Long id) {
        return appGoodsSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int createGoodsSort(AppGoodsSort appGoodsSort, Long channelId) {
        appGoodsSort.setChannelId(channelId);
        return appGoodsSortMapper.insertSelective(appGoodsSort);
    }

    @Override
    public int updateGoodsSort(Long id, AppGoodsSort appGoodsSort) {
        appGoodsSort.setId(id);
        return appGoodsSortMapper.updateByPrimaryKey(appGoodsSort);

    }
}