package my.fast.admin.cg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.service.AppMemberDepositService;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.ListDepositParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/29 15:56
 */
@Controller
@Api(tags = "AppMemberDepositController", description = "app获取会员充值列表")
@RequestMapping("/app/deposit")
public class AppMemberDepositController {

    @Autowired
    private AppChannelService appChannelService;

    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    AppMemberDepositService appMemberDepositService;

    @ApiOperation(value = "根据条件获取分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberDeposit>> getList(@RequestBody ListDepositParam deposit,
        HttpServletRequest request) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
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
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        deposit.setChannelId(channelId);
        List<AppMemberDeposit> depositList = appMemberDepositService.listDeposit(deposit, deposit.getPageNum(),
            deposit.getPageSize());
        return CommonResult.success(CommonPage.restPage(depositList));
    }

}
