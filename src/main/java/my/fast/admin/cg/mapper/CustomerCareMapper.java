package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.CustomerCare;
import my.fast.admin.cg.entity.CustomerCareExample;

public interface CustomerCareMapper {
    long countByExample(CustomerCareExample example);

    int deleteByExample(CustomerCareExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerCare record);

    int insertSelective(CustomerCare record);

    List<CustomerCare> selectByExample(CustomerCareExample example);

    CustomerCare selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerCare record, @Param("example") CustomerCareExample example);

    int updateByExample(@Param("record") CustomerCare record, @Param("example") CustomerCareExample example);

    int updateByPrimaryKeySelective(CustomerCare record);

    int updateByPrimaryKey(CustomerCare record);
}