package com.macro.mall.mapper;

import com.macro.mall.model.AppGoods;
import com.macro.mall.model.AppGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppGoodsMapper {
    long countByExample(AppGoodsExample example);

    int deleteByExample(AppGoodsExample example);

    int deleteByPrimaryKey(String id);

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