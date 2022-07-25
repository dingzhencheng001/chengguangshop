package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppGoodsSort;
import my.fast.admin.cg.entity.AppGoodsSortExample;

public interface AppGoodsSortMapper {
    long countByExample(AppGoodsSortExample example);

    int deleteByExample(AppGoodsSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppGoodsSort record);

    int insertSelective(AppGoodsSort record);

    List<AppGoodsSort> selectByExampleWithBLOBs(AppGoodsSortExample example);

    List<AppGoodsSort> selectByExample(AppGoodsSortExample example);

    AppGoodsSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppGoodsSort record, @Param("example") AppGoodsSortExample example);

    int updateByExampleWithBLOBs(@Param("record") AppGoodsSort record, @Param("example") AppGoodsSortExample example);

    int updateByExample(@Param("record") AppGoodsSort record, @Param("example") AppGoodsSortExample example);

    int updateByPrimaryKeySelective(AppGoodsSort record);

    int updateByPrimaryKeyWithBLOBs(AppGoodsSort record);

    int updateByPrimaryKey(AppGoodsSort record);
}