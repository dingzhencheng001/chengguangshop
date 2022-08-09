package my.fast.admin.cg.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppConvey;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.AppConveyParam;
import my.fast.admin.cg.model.QiangNumParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.ConveyService;
import my.fast.admin.cg.vo.AppConveyDto;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 11:49
 */
@Controller
@Api(tags = "ConveyController", description = "后台交易订单管理")
@RequestMapping("/action/convey")
public class ConveyController {

    @Autowired
    private ConveyService ConveyService;

    @Autowired
    private AppChannelService appChannelService;

    @RequestMapping("/lists")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("transaction/orderList");
        return mav;
    }

    @ApiOperation(value = "根据条件获取订单分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppConveyDto>> getList(@RequestBody AppConveyParam appConveyParam,
        HttpServletRequest request) {
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
        List<AppConveyDto> conveyList = ConveyService.listConvey(appConveyParam, channelId);
        return CommonResult.success(CommonPage.restPage(conveyList));
    }

    @ApiOperation(value = "删除交易订单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = ConveyService.deleteConveyById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新交易订单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody AppConvey appConvey) {
        CommonResult commonResult;
        int count = ConveyService.updateConvey(id, appConvey);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加交易订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppConvey appConvey, HttpServletRequest request) {
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
        appConvey.setChannelId(channelId);
        CommonResult commonResult;
        int count = ConveyService.createConvey(appConvey);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "根据日期和会员id查询当日抢单数")
    @RequestMapping(value = "/qiang", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult selectFinishOrder(@RequestBody QiangNumParam qiangNumParam, HttpServletRequest request) {
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
        qiangNumParam.setChannelId(channelId);
        Long order = ConveyService.selectFinishOrder(qiangNumParam);
        return CommonResult.success(order);
    }
}