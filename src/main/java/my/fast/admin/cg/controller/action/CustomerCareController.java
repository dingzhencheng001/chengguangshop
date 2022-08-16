package my.fast.admin.cg.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.CustomerCare;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.CustomerCareParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.CustomerCareService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:02
 */
@Controller
@Api(tags = "CustomerCareController", description = "客服管理")
@RequestMapping("/action/customer")
public class CustomerCareController {


    @Autowired
    private CustomerCareService customerCareService;

    @Autowired
    private AppChannelService appChannelService;

    @RequestMapping("/lists")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customer/list");
        return mav;
    }

    @ApiOperation(value = "客服管理列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<CustomerCare>> getOperateLogList(@RequestBody CustomerCareParam param, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        param.setChannelId(channelId);
        List<CustomerCare> list = customerCareService.getCustomerCareList(param,param.getPageNum(), param.getPageSize());
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation(value = "新增客服")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody CustomerCare customerCare,HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        CommonResult commonResult;
        customerCare.setChannelId(channelId);
        int count = customerCareService.createCustomerCare(customerCare, channelId);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    
    @ApiOperation(value = "更新客服信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody CustomerCare customerCare,HttpServletRequest request) {
        CommonResult commonResult;
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        customerCare.setChannelId(channelId);
        customerCare.setUpdateBy("admin");
        customerCare.setUpdateTime(DateFormat.getNowDate());
        int count = customerCareService.updateCustomerCare(id, customerCare);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
    

}

