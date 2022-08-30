package my.fast.admin.cg.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppGoodsExample;
import my.fast.admin.cg.model.DispatchOrderParam;
import my.fast.admin.cg.vo.AppGoodsVo;

public interface AppGoodsMapper {
    long countByExample(AppGoodsExample example);

    int deleteByExample(AppGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppGoods record);

    int insertSelective(AppGoods record);

    List<AppGoods> selectByExample(AppGoodsExample example);

    AppGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppGoods record, @Param("example") AppGoodsExample example);

    int updateByExample(@Param("record") AppGoods record, @Param("example") AppGoodsExample example);

    int updateByPrimaryKeySelective(AppGoods record);

    int updateByPrimaryKey(AppGoods record);

    AppGoods randomOrders(@Param("mateMinGoodsPrice")BigDecimal mateMinGoodsPrice, @Param("mateMaxGoodsPrice")BigDecimal mateMaxGoodsPrice);

    AppGoods selectByGoodsId(@Param("id")Long id, @Param("channelId")Long channelId);

    AppGoods randomGoodsByExample(DispatchOrderParam dispatchOrderParam);

    int insertGoodsList(@Param("list") List<AppGoods> list);


}