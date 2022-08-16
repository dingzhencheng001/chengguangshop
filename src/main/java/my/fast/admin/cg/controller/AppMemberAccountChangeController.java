package my.fast.admin.cg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAccountChange;
import my.fast.admin.cg.service.AppMemberAccountChangeService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Controller
@Api(tags = "AppMemberAccountChangeController", description = "APP用户账变管理")
@RequestMapping("/app/account")
public class AppMemberAccountChangeController {
    @Autowired
    private AppMemberService appMemberService;
    @Autowired
    private AppMemberAccountChangeService accountChangeControllerService;

    @ApiOperation("获取用户账变列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMemberAccountChange> appAccountChange = accountChangeControllerService.listAll();
        return CommonResult.success(appAccountChange);
    }

    @ApiOperation(value = "查询个人账户情况")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberAccountChange>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, @RequestParam(required = false) Integer type,
        HttpServletRequest request) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        //查询账户交易账变记录
        Long memberId = appUserVO.getId();
        List<AppMemberAccountChange> appMemberAccountChangeList = accountChangeControllerService.listAccountChange(type,memberId,
            pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberAccountChangeList));
    }

    
    @ApiOperation(value = "删除用户账变")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = accountChangeControllerService.deleteAccountChangeById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新用户账变")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,
        @RequestBody AppMemberAccountChange appMemberAccountChange) {
        CommonResult commonResult;
        int count = accountChangeControllerService.updateAccountChange(id, appMemberAccountChange);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加用户账变")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppMemberAccountChange appMemberAccountChange) {
        CommonResult commonResult;
        int count = accountChangeControllerService.createAccountChange(appMemberAccountChange);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}
