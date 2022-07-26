package my.fast.admin.cg.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.AppGoodsExample;

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

    AppGoods randomOrders(BigDecimal useBalance);

    AppGoods selectByGoodsId(@Param("id")Long id, @Param("channelId")Long channelId);
}