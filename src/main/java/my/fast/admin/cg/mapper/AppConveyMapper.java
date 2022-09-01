package my.fast.admin.cg.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.AppConveyExample;
import my.fast.admin.cg.model.AppConveyParam;
import my.fast.admin.cg.model.AppRandomOrderParam;
import my.fast.admin.cg.model.MemberDepositParam;
import my.fast.admin.cg.model.QiangNumParam;
import my.fast.admin.cg.vo.AppConveyDto;
import my.fast.admin.cg.vo.AppConveyVo;

public interface AppConveyMapper {
    long countByExample(AppConveyExample example);

    int deleteByExample(AppConveyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppConvey record);

    int insertSelective(AppConvey record);

    List<AppConvey> selectByExample(AppConveyExample example);

    AppConvey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppConvey record, @Param("example") AppConveyExample example);

    int updateByExample(@Param("record") AppConvey record, @Param("example") AppConveyExample example);

    int updateByPrimaryKeySelective(AppConvey record);

    int updateByPrimaryKey(AppConvey record);

    List<AppConvey> selectConvey(@Param("memberId") Long memberId,@Param("channelId")Long channelId);

    List<AppConveyDto> selectByConveyByStatus(@Param("appConveyParam") AppConveyParam appConveyParam,
        @Param("channelId") Long channelId);

    List<AppConveyDto> selectUserConvey(AppConveyParam appConveyParam);

    List<AppConvey> selectFinishOrder(QiangNumParam qiangNumParam);

    List<AppConveyVo> selectConveyInfo(AppConveyParam appConveyParam);

    List<AppConveyVo> selectConveyInfoByPd(AppConveyParam appConveyParam);

    List<AppConvey> selectQiang(AppRandomOrderParam appRandomOrderParam);

    List<AppConvey> selectMemberConvey(MemberDepositParam depositParam);

    /**
     * 查询当日佣金
     * @param memberId
     * @param channelId
     */
    BigDecimal selectTodayCommission(@Param("memberId") Long memberId,@Param("channelId")Long channelId);

}