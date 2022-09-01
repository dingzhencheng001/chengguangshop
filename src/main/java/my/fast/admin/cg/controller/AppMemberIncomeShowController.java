package my.fast.admin.cg.controller;

import java.util.List;

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
import my.fast.admin.cg.entity.AppShow;
import my.fast.admin.cg.service.AppMemberIncomeShowService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/1 15:51
 */
@Controller
@Api(tags = "AppMemberIncomeShowController", description = "app会员收入展示")
@RequestMapping("/app/account")
public class AppMemberIncomeShowController {

    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    private AppMemberIncomeShowService appMemberIncomeShowService;

    @ApiOperation(value = "app会员收入展示")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult selectMemberLevel(HttpServletRequest request) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        List<AppShow> appShowList = appMemberIncomeShowService.memberIncomeShow();
        return CommonResult.success(appShowList);
    }

}
