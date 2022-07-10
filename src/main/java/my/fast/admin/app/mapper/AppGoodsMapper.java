package my.fast.admin.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.entity.AppGoodsExample;

public interface AppGoodsMapper {
    long countByExample(AppGoodsExample example);

    int deleteByExample(AppGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppGoods record);

    int insertSelective(AppGoods record);

    List<AppGoods> selectByExampleWithBLOBs(AppGoodsExample example);

    List<AppGoods> selectByExample(AppGoodsExample example);

    AppGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppGoods record, @Param("example") AppGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") AppGoods record, @Param("example") AppGoodsExample example);

    int updateByExample(@Param("record") AppGoods record, @Param("example") AppGoodsExample example);

    int updateByPrimaryKeySelective(AppGoods record);

    int updateByPrimaryKeyWithBLOBs(AppGoods record);

    int updateByPrimaryKey(AppGoods record);
}