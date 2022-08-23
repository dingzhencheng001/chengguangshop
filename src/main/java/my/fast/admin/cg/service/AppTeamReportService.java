package my.fast.admin.cg.service;

import java.util.List;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.model.AppTeamParam;
import my.fast.admin.cg.model.MemberParam;
import my.fast.admin.cg.vo.AppTeamReportVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:07
 */
public interface AppTeamReportService {

    /**
     * 获取下级会员信息
     */
    AppTeamReportVo getTeamList(AppTeamParam appTeamParam);
   
   
   /**
    * 获取下级团队信息
    */
  List<AppMember> getTeamLevelList(MemberParam param, Integer pageNum, Integer pageSize);
  
}
