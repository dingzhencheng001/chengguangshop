package my.fast.admin.cg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.service.AppNoticeService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:02
 */
@Controller
@Api(tags = "AppNoticeController", description = "APP消息通知管理")
@RequestMapping("/app/notice")
public class AppNoticeController {

    @Autowired
    private AppNoticeService appNoticeService;

    @Autowired
    private AppMemberService appMemberService;

    @ApiOperation(value = "获取个人消息通知列表")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysNotice>> getMemberNoticeList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, HttpServletRequest request) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("813");
        }
        Long memberId = appUserVO.getId();
        List<SysNotice> noticeList = appNoticeService.getMemberNoticeList(pageNum, pageSize,memberId);
        return CommonResult.success(CommonPage.restPage(noticeList));
    }

}

