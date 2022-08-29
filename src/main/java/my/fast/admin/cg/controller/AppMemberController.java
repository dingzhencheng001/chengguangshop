package my.fast.admin.cg.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.entity.SysAgentList;
import my.fast.admin.cg.service.AppAgentListService;
import my.fast.admin.cg.service.AppMemberLevelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.vo.AppMemberDto;
import my.fast.admin.cg.vo.AppMemberVo;
import my.fast.admin.framework.utils.TokenUtils;

/**
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Controller
@Api(tags = "AppMemberController", description = "APP会员管理")
@RequestMapping("/app/member")
public class AppMemberController {
    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    private AppMemberLevelService appMemberLevelService;

    @Autowired
    private AppAgentListService agentListService;


    @ApiOperation(value = "首页信息")
    @RequestMapping(value = "/homePage", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult homePage(HttpServletRequest request) {

        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        AppMemberVo reVo = new AppMemberVo();
        AppMember voInfo = appMemberService.selectAppMemberByUserId(appUserVO.getId());
        if (voInfo == null) {
            return CommonResult.failed("813");
        }
        BeanUtils.copyProperties(voInfo, reVo);
        //首页设置余额
        reVo.setBalance(voInfo.getBalance());
        //今日佣金 -- 根据用户ID 从账变表 类型为佣金 取今日数据累加 TODO= 账变表字段加类型
        reVo.setTodaySum(new BigDecimal(0));
        //总佣金
        reVo.setTotalCommission(voInfo.getTotalCommission());

        //会员等级List
        List<AppMemberLevel> levelList = appMemberLevelService.listAll();
        if (levelList == null) {
            return CommonResult.failed("816");
        }
        reVo.setLevelList(levelList);

        //代理收益列表获取 ? 查找逻辑是 我的上级代理还是下级代理 ？ --暂查询随机展示
        List<SysAgentList> agentList = agentListService.listAll();
        if (agentList == null) {
            return CommonResult.failed("817");
        }
        reVo.setAgentList(agentList);

        //中部部图片管理 TODO= 
        //底部图片管理 TODO= 

        return CommonResult.success(reVo);
    }

    @ApiOperation(value = "获取会员个人信息")
    @RequestMapping(value = "/member/information", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult memberInfo(HttpServletRequest request) {

        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }

        AppMember voInfo = appMemberService.selectAppMemberByUserId(appUserVO.getId());
        if (voInfo == null) {
            return CommonResult.failed("813");
        }

        return CommonResult.success(voInfo);
    }

    @ApiOperation(value = "获取会员账户信息")
    @RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult memberCountInfo(HttpServletRequest request) {

        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        AppMemberDto memberInfo = appMemberService.selectAppMemberCountByPrimary(appUserVO.getId());
        if (memberInfo == null) {
            return CommonResult.failed("813");
        }
        memberInfo.setId(appUserVO.getId());
        return CommonResult.success(memberInfo);
    }

}
