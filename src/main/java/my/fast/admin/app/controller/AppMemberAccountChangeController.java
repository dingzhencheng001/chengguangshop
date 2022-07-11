package my.fast.admin.app.controller;

import java.util.List;

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
import my.fast.admin.app.common.constant.CommonPage;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppMemberAccountChange;
import my.fast.admin.app.service.AppMemberAccountChangeControllerService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Controller
@Api(tags = "AppMemberAccountChangeController", description = "用户账变管理")
@RequestMapping("/memberaccountchange")
public class AppMemberAccountChangeController {
    @Autowired
    private AppMemberAccountChangeControllerService accountChangeControllerService;

    @ApiOperation("获取用户账变列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMemberAccountChange> appAccountChange = accountChangeControllerService.listAll();
        return CommonResult.success(appAccountChange);
    }

    @ApiOperation(value = "根据条件获取分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberAccountChange>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize ,@RequestBody AppMemberAccountChange appMemberAccountChange) {
        List<AppMemberAccountChange> appMemberAccountChangeList = accountChangeControllerService.listAccountChange(appMemberAccountChange, pageNum, pageSize);
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
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppMemberAccountChange appMemberAccountChange) {
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
