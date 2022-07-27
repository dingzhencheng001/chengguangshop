package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.model.MemberParam;
import my.fast.admin.cg.service.AppTeamReportService;
import my.fast.admin.cg.vo.AppCommissionVo;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:09
 */
@Service
public class AppTeamReportServiceImpl implements AppTeamReportService {

    @Autowired
    private AppMemberMapper appMemberMapper;

    @Override
    public AppCommissionVo getTeamList(Long id) {
        List<AppMember> appMemberList = appMemberMapper.getMemberTeam(id);
        AppMember appMember = appMemberMapper.selectByPrimaryKey(id);
        //分组
        AppCommissionVo appCommissionVo = subgroup(appMemberList);
        //统计
        calculation(appCommissionVo);
        appCommissionVo.setTotalCommission(appMember.getTotalCommission());
        return appCommissionVo;
    }

    /**
     * 按照等级分组
     */
    private AppCommissionVo subgroup(List<AppMember> appMemberList) {
        AppCommissionVo appCommissionVo = new AppCommissionVo();
        for (AppMember appMember : appMemberList) {
            if ((appMember.getMemberLevelId() == 1)) {
                List<AppMember> primaryAgents = new ArrayList<AppMember>();
                primaryAgents.add(appMember);
                appCommissionVo.setPrimaryAgents(primaryAgents);
            }
            if ((appMember.getMemberLevelId() == 2)) {
                List<AppMember> secondaryAgents = new ArrayList<AppMember>();
                secondaryAgents.add(appMember);
                appCommissionVo.setSecondaryAgents(secondaryAgents);
            }
            if ((appMember.getMemberLevelId() == 3)) {
                List<AppMember> tertiaryAgent = new ArrayList<AppMember>();
                tertiaryAgent.add(appMember);
                appCommissionVo.setTertiaryAgent(tertiaryAgent);
            }
            if ((appMember.getMemberLevelId() == 4)) {
                List<AppMember> fourLevelAgent = new ArrayList<AppMember>();
                fourLevelAgent.add(appMember);
                appCommissionVo.setFourLevelAgent(fourLevelAgent);
            }
            if ((appMember.getMemberLevelId() == 5)) {
                List<AppMember> fiveLevelAgent = new ArrayList<AppMember>();
                fiveLevelAgent.add(appMember);
                appCommissionVo.setFiveLevelAgent(fiveLevelAgent);
            }
        }
        return appCommissionVo;
    }

    /**
     * 分组后的数据统计
     *
     * @param appCommissionVo
     */
    private AppCommissionVo calculation(AppCommissionVo appCommissionVo) {
        //一级
        List<AppMember> primaryAgents = appCommissionVo.getPrimaryAgents();
        if(primaryAgents!= null && primaryAgents.size()>0){
            BigDecimal primaryAgentsTotalCommission = primaryAgents.stream()
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appCommissionVo.setPrimaryAgentsTotalCommission(primaryAgentsTotalCommission);

        }
        //二级
        List<AppMember> secondaryAgents = appCommissionVo.getSecondaryAgents();
        if (secondaryAgents != null && secondaryAgents.size() > 0) {
            BigDecimal secondaryAgentsTotalCommission = secondaryAgents.stream()
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appCommissionVo.setSecondaryAgentsTotalCommission(secondaryAgentsTotalCommission);

        }
        //三级
        List<AppMember> tertiaryAgents = appCommissionVo.getTertiaryAgent();
        if (tertiaryAgents != null && tertiaryAgents.size()>0){
            BigDecimal tertiaryAgentTotalCommission = tertiaryAgents.stream()
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appCommissionVo.setTertiaryAgentTotalCommission(tertiaryAgentTotalCommission);
        }
        //四级
        List<AppMember> fourLevelAgents = appCommissionVo.getFourLevelAgent();
        if(fourLevelAgents  != null && fourLevelAgents.size()>0){
            BigDecimal fourLevelAgentTotalCommission = fourLevelAgents.stream()
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appCommissionVo.setFourLevelAgentTotalCommission(fourLevelAgentTotalCommission);
        }
        //五级
        List<AppMember> fiveLevelAgents = appCommissionVo.getFiveLevelAgent();
        if (fiveLevelAgents !=null && fiveLevelAgents.size()>0){
            BigDecimal fiveLevelAgentTotalCommission = fiveLevelAgents.stream()
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appCommissionVo.setFiveLevelAgentTotalCommission(fiveLevelAgentTotalCommission);
        }
        return appCommissionVo;
    }

	@Override
	public List<AppMember> getTeamLevelList(MemberParam param, Integer pageNum, Integer pageSize) {
		return appMemberMapper.getTeamLevelList(param.getMemberId(), param);
	}
}
