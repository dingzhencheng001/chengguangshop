package my.fast.admin.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.service.AppMemberLevelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 14:32
 */
@Controller
@Api(tags = "AppMemberLevelController", description = "APP会员等级管理")
@RequestMapping("/app/level")
public class AppMemberLevelController {

    @Autowired
    private AppMemberLevelService appMemberLevelService;

    @Autowired
    private AppMemberService appMemberService;


    @ApiOperation("获取会员列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMemberLevel> appMemberLevels = appMemberLevelService.listAll();
        return CommonResult.success(appMemberLevels);
    }

    @ApiOperation(value = "获取会员等级列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberLevel>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<AppMemberLevel> appMemberLevels = appMemberLevelService.listLevels(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberLevels));
    }

    @ApiOperation(value = "删除会员等级")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appMemberLevelService.deleteLevels(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新会员等级")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody AppMemberLevel appMemberLevel) {
        CommonResult commonResult;
        int count = appMemberLevelService.updateLevels(id, appMemberLevel);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加会员等级")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppMemberLevel appMemberLevel) {
        CommonResult commonResult;
        int count = appMemberLevelService.createLevels(appMemberLevel);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}
