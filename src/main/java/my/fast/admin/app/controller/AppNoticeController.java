package my.fast.admin.app.controller;

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
import my.fast.admin.app.common.constant.CommonPage;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.SysNotice;
import my.fast.admin.app.service.AppMemberService;
import my.fast.admin.app.service.AppNoticeService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:02
 */
@Controller
@Api(tags = "AppNoticeController", description = "消息通知管理")
@RequestMapping("/notice")
public class AppNoticeController {

    @Autowired
    private AppNoticeService appNoticeService;

    @Autowired
    private AppMemberService appMemberService;

    @ApiOperation(value = "获取全部消息通知")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SysNotice>> getList() {
        return CommonResult.success(appNoticeService.listAllNotice());
    }

    @ApiOperation(value = "获取消息通知列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysNotice>> getNoticeList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<SysNotice> noticeList = appNoticeService.getNoticeList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(noticeList));
    }

    @ApiOperation(value = "删除消息通知")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appNoticeService.deleteNotice(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新消息通知")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody SysNotice sysNotice) {
        CommonResult commonResult;
        int count = appNoticeService.updateNotice(id, sysNotice);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "新增新消息通知")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody SysNotice sysNotice) {
        CommonResult commonResult;
        int count = appNoticeService.createNotice(sysNotice);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "获取个人消息通知列表")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysNotice>> getMemberNoticeList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, HttpServletRequest request) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户信息不存在");
        }
        Long memberId = appUserVO.getId();
        List<SysNotice> noticeList = appNoticeService.getMemberNoticeList(pageNum, pageSize,memberId);
        return CommonResult.success(CommonPage.restPage(noticeList));
    }

}

