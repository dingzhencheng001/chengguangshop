package my.fast.admin.cg.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppDispatchOrder;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.DispatchOrderParam;
import my.fast.admin.cg.model.DispatchParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.DispatchOrderService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/30 14:06
 */

@Controller
@Api(tags = "DispatchOrderController", description = "派单管理")
@RequestMapping("/action/dispatch")
public class DispatchOrderController {

    @Autowired
    private DispatchOrderService dispatchOrderService;

    @Autowired
    private AppChannelService appChannelService;

    @ApiOperation(value = "派单")
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult assignGoods(@Validated @RequestBody List<DispatchOrderParam> DispatchOrderParam,
        HttpServletRequest request) throws Exception {
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
        DispatchOrderParam.forEach(item -> item.setChannelId(channelId));
        int count = dispatchOrderService.assignGoods(DispatchOrderParam);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据条件获取派单列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppDispatchOrder>> getOrderList(HttpServletRequest request,
        @RequestBody DispatchParam dispatchParam) {
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
        dispatchParam.setChannelId(channelId);
        List<AppDispatchOrder> orderList = dispatchOrderService.getOrderList(dispatchParam);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation(value = "派单商品价格校验")
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult checkPrice(@RequestBody DispatchOrderParam dispatchOrderParam, HttpServletRequest request)
    throws Exception {
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
        dispatchOrderParam.setChannelId(channelId);
        int count = dispatchOrderService.checkPrice(dispatchOrderParam);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据时间查组")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult findGroupByTime(HttpServletRequest request, @RequestBody DispatchParam dispatchParam) {
        CommonResult commonResult;
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
        dispatchParam.setChannelId(channelId);
        List<Integer> orderList = dispatchOrderService.findGroup(dispatchParam);
        if (orderList.size() > 0) {
            commonResult = CommonResult.success(orderList);
        } else {
            commonResult = CommonResult.success(1);
        }
        return commonResult;
    }

    @ApiOperation(value = "校验是否有重复单")
    @RequestMapping(value = "/verification", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult checkOrderQuantity(@RequestBody DispatchOrderParam dispatchOrderParam,
        HttpServletRequest request) throws Exception {
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
        dispatchOrderParam.setChannelId(channelId);
        int count = dispatchOrderService.checkOrderQuantity(dispatchOrderParam);
        if (count >= 1) {
            return CommonResult.failed("单号重复,请重新输入!");
        } else {
            return CommonResult.success(null);
        }
    }

    @ApiOperation(value = "查询派单列表最大单号")
    @RequestMapping(value = "/big/order", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult selectBigOrderNo(@RequestBody DispatchOrderParam dispatchOrderParam, HttpServletRequest request) {
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
        dispatchOrderParam.setChannelId(channelId);
        int num = dispatchOrderService.selectBigOrderNo(dispatchOrderParam);
        return CommonResult.success(num);

    }

}
