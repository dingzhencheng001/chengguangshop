package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.AppMemberDepositExample;

public interface AppMemberDepositMapper {
    long countByExample(AppMemberDepositExample example);

    int deleteByExample(AppMemberDepositExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppMemberDeposit record);

    int insertSelective(AppMemberDeposit record);

    List<AppMemberDeposit> selectByExample(AppMemberDepositExample example);

    AppMemberDeposit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppMemberDeposit record, @Param("example") AppMemberDepositExample example);

    int updateByExample(@Param("record") AppMemberDeposit record, @Param("example") AppMemberDepositExample example);

    int updateByPrimaryKeySelective(AppMemberDeposit record);

    int updateByPrimaryKey(AppMemberDeposit record);
}