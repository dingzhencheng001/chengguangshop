package my.fast.admin.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppShow;
import my.fast.admin.cg.entity.AppShowExample;

public interface AppShowMapper {
    long countByExample(AppShowExample example);

    int deleteByExample(AppShowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppShow row);

    int insertSelective(AppShow row);

    List<AppShow> selectByExample(AppShowExample example);

    AppShow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") AppShow row, @Param("example") AppShowExample example);

    int updateByExample(@Param("row") AppShow row, @Param("example") AppShowExample example);

    int updateByPrimaryKeySelective(AppShow row);

    int updateByPrimaryKey(AppShow row);

    List<AppShow> selectMemberIncome();

}