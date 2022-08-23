package my.fast.admin.cg.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.mapper.AppMemberMapper;
import my.fast.admin.cg.model.AppTeamParam;
import my.fast.admin.cg.model.AppTeamReportInfo;
import my.fast.admin.cg.model.MemberParam;
import my.fast.admin.cg.service.AppTeamReportService;
import my.fast.admin.cg.vo.AppTeamAllVo;
import my.fast.admin.cg.vo.AppTeamReportVo;
import my.fast.admin.cg.vo.AppTeamVo;

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
    public AppTeamReportVo getTeamList(AppTeamParam appTeamParam) {
        AppTeamReportVo appTeamReportVo = new AppTeamReportVo();
        List<AppTeamVo> appTeamVos = new ArrayList<>();
        List<AppMember> appMemberList = appMemberMapper.getMemberTeam(appTeamParam);
        AppTeamAllVo appTeamAllVo = new AppTeamAllVo();
        if (appMemberList != null && appMemberList.size() > 0) {
            //统计所有
            getAppTeamReportVos(appTeamParam, appMemberList, appTeamReportVo, appTeamAllVo);
            //分级统计
            calculationByLevelId(appTeamParam, appMemberList, appTeamReportVo, appTeamVos, 1L);
            calculationByLevelId(appTeamParam, appMemberList, appTeamReportVo, appTeamVos, 2L);
            calculationByLevelId(appTeamParam, appMemberList, appTeamReportVo, appTeamVos, 3L);
            calculationByLevelId(appTeamParam, appMemberList, appTeamReportVo,appTeamVos,4L);
            calculationByLevelId(appTeamParam, appMemberList, appTeamReportVo,appTeamVos,5L);
        }
        return appTeamReportVo;
    }

    private AppTeamReportVo calculationByLevelId(AppTeamParam appTeamParam, List<AppMember> appMemberList,
        AppTeamReportVo appTeamReportVo, List<AppTeamVo> appTeamVos, Long memberLevelId) {
        List<Long> collect = appMemberList.stream()
            .map(AppMember::getMemberLevelId)
            .collect(Collectors.toList());
        boolean contains = collect.contains(memberLevelId);
        if (contains) {
            BigDecimal teamBalance = appMemberList.stream()
                .filter(p -> p.getMemberLevelId()
                    .equals(memberLevelId))
                .map(e -> e.getBalance())
                .reduce(BigDecimal::add)
                .get();
            int teamSize = appMemberList.stream()
                .filter(p -> p.getMemberLevelId()
                    .equals(memberLevelId))
                .collect(Collectors.toList())
                .size();
            BigDecimal teamCommission = appMemberList.stream()
                .filter(p -> p.getMemberLevelId()
                    .equals(memberLevelId))
                .map(e -> e.getTotalCommission())
                .reduce(BigDecimal::add)
                .get();
            appTeamParam.setMemberLevelId(memberLevelId);
            List<AppTeamReportInfo> agentList = appMemberMapper.getAgentListInfoByLevelId(appTeamParam);
            AppTeamVo appTeamVo = new AppTeamVo();
            appTeamVo.setMemberLevelId(memberLevelId);
            appTeamVo.setTeamSize(teamSize);
            appTeamVo.setTeamBalance(teamBalance);
            appTeamVo.setTeamCommission(teamCommission);
            appTeamVo.setSubordinate(agentList);
            appTeamVos.add(appTeamVo);
            appTeamReportVo.setAppTeamVo(appTeamVos);
        } else {
            return null;
        }
        return appTeamReportVo;
    }

    public AppTeamReportVo getAppTeamReportVos(AppTeamParam appTeamParam, List<AppMember> appMemberList,
        AppTeamReportVo appTeamReportVo, AppTeamAllVo appTeamAllVo) {
        BigDecimal allBalance = appMemberList.stream()
            .map(e -> e.getBalance())
            .reduce(BigDecimal::add)
            .get();
        int allSize = appMemberList.size();
        BigDecimal allCommission = appMemberList.stream()
            .map(e -> e.getTotalCommission())
            .reduce(BigDecimal::add)
            .get();
        List<AppTeamReportInfo> agentList = appMemberMapper.getAgentListInfo(appTeamParam);
        appTeamAllVo.setAllBalance(allBalance);
        appTeamAllVo.setAllSize(allSize);
        appTeamAllVo.setAllCommission(allCommission);
        appTeamAllVo.setSubordinate(agentList);
        appTeamReportVo.setAppTeamAllVo(appTeamAllVo);
        return appTeamReportVo;
    }

    @Override
    public List<AppMember> getTeamLevelList(MemberParam param, Integer pageNum, Integer pageSize) {
        return appMemberMapper.getTeamLevelList(param.getMemberId(), param);
    }
}

