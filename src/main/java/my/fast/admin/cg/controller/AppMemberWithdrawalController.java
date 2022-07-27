package my.fast.admin.cg.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.service.AppMemberWithdrawalService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/27 15:12
 */
@Controller
@Api(tags = "AppMemberWithdrawalController", description = "APP提现管理")
@RequestMapping("/app/member")
public class AppMemberWithdrawalController {

    @Autowired
    private AppMemberWithdrawalService appMemberWithdrawalService;

    @Autowired
    private AppChannelService appChannelService;

    @Autowired
    private AppMemberService appMemberService;

    @ApiOperation("用户提现")
    @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult Withdrawal(HttpServletRequest request, @RequestBody MemberWithdrawalParam memberWithdrawalParam)
    throws Exception {
        CommonResult commonResult;
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        Long memberId = appUserVO.getId();
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId() == null) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        BigDecimal withdrawalNum = memberWithdrawalParam.getOperaMount();
        int count = appMemberWithdrawalService.withdrawal(channelId, memberId, withdrawalNum);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}