package my.fast.admin.cg.controller;

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
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.AppRandomOrderParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.AppGrabOrdersService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 14:56
 */

@Controller
@Api(tags = "AppGrabOrdersController", description = "APP抢单管理")
@RequestMapping("/app/grab")
public class AppGrabOrdersController {
    @Autowired
    private AppGrabOrdersService appGrabOrdersService;

    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    private AppChannelService appChannelService;

    @ApiOperation(value = "随机生成抢单商品")
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult randomOrders(HttpServletRequest request) throws Exception {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("813");
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
        //判断该账户提现状态是否正常
        if (CommonUtils.moneyComp(appUserVO.getBalance(), appUserVO.getLimitAmount())) {
            AppRandomOrderParam appRandomOrderParam = new AppRandomOrderParam();
            appRandomOrderParam.setMemberId(appUserVO.getId());
            appRandomOrderParam.setChannelId(channelId);
            Object appGoods = appGrabOrdersService.randomOrders(appRandomOrderParam);
            return CommonResult.success(appGoods);
        } else {
            return CommonResult.failed("814");
        }
    }

    @ApiOperation(value = "提交随机生成的订单")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitOrders(HttpServletRequest request, @RequestBody Object appGoods) throws Exception {
        CommonResult commonResult;
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("813");
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
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        int count = appGrabOrdersService.submitOrders(appGoods, memberId, channelId);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}

