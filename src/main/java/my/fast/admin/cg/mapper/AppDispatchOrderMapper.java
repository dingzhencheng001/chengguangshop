package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppDispatchOrder;
import my.fast.admin.cg.entity.AppDispatchOrderExample;
import my.fast.admin.cg.model.DispatchOrderParam;
import my.fast.admin.cg.model.DispatchParam;

public interface AppDispatchOrderMapper {
    long countByExample(AppDispatchOrderExample example);

    int deleteByExample(AppDispatchOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppDispatchOrder record);

    int insertSelective(AppDispatchOrder record);

    List<AppDispatchOrder> selectByExample(AppDispatchOrderExample example);

    AppDispatchOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppDispatchOrder record, @Param("example") AppDispatchOrderExample example);

    int updateByExample(@Param("record") AppDispatchOrder record, @Param("example") AppDispatchOrderExample example);

    int updateByPrimaryKeySelective(AppDispatchOrder record);

    int updateByPrimaryKey(AppDispatchOrder record);

    /**
     * 获取派单列表
     */
    List<AppDispatchOrder> selectOrderList(DispatchParam dispatchParam);

    /**
     * 获取时间获取列表
     */
    List<AppDispatchOrder> findGroup(DispatchParam dispatchParam);

    /**
     * 校验单数是否重复
     */
    int checkOrderQuantity(DispatchOrderParam dispatchOrderParam);

}