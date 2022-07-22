package my.fast.admin.app.service;

import java.util.List;

import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.vo.AppCommissionVo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:07
 */
public interface AppTeamReportService {

    /**
     * 获取会员团队信息
     * @param id
     */
   AppCommissionVo getTeamList(Long id);
   
   
   /**
    * 获取会员团队信息
    * @param id ,memberLevel
    */
  List<AppMember> getTeamLevelList(Long id,Long memberLevel);
  
}
