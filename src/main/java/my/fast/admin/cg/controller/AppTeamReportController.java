package my.fast.admin.cg.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.service.AppTeamReportService;
import my.fast.admin.cg.vo.AppCommissionVo;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 12:01
 */
@Controller
@Api(tags = "AppTeamReportController", description = "APP会员团队信息管理")
@RequestMapping("/app/team")
public class AppTeamReportController {

    @Autowired
    private AppTeamReportService appTeamReportService;


    @Autowired
    private AppMemberService appMemberService;

    @ApiOperation(value = "获取会员团队信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AppCommissionVo> getList(HttpServletRequest request) {

        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        Long id = appUserVO.getId();
        return CommonResult.success(appTeamReportService.getTeamList(id));
    }

}
