package my.fast.admin.cg.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppAssignGoods;
import my.fast.admin.cg.entity.AppAssignGoodsExample;
import my.fast.admin.cg.model.AppRandomOrderParam;

public interface AppAssignGoodsMapper {
    long countByExample(AppAssignGoodsExample example);

    int deleteByExample(AppAssignGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppAssignGoods record);

    int insertSelective(AppAssignGoods record);

    List<AppAssignGoods> selectByExample(AppAssignGoodsExample example);

    AppAssignGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppAssignGoods record,
        @Param("example") AppAssignGoodsExample example);

    int updateByExample(@Param("record") AppAssignGoods record, @Param("example") AppAssignGoodsExample example);

    int updateByPrimaryKeySelective(AppAssignGoods record);

    int updateByPrimaryKey(AppAssignGoods record);

    /**
     * 获取指派单商品库
     */
    List<AppAssignGoods> assignGoodsList(AppRandomOrderParam appRandomOrderParam);

    /**
     * 删除修改前生成的商品
     */
    int deleteAssignGoods(@Param("flag") Integer flag,@Param("serialNumber") String serialNumber);

    /**
     * 找出当前组的商品
     */
    List<AppAssignGoods> selectGroupAssignGoods(@Param("whichGroup")Integer whichGroup, @Param("date") String date, @Param("memberId")Long memberId,@Param("channelId") Long channelId);
}