package my.fast.admin.cg.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.entity.SysOperateLog;
import my.fast.admin.cg.model.OperateLogParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.OperateLogService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:02
 */
@Controller
@Api(tags = "OperateLogController", description = "操作日志管理")
@RequestMapping("/action/operate")
public class OperateLogController {

	@RequestMapping("/log")
	public Object list() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("log/log");
			return mav;
	}

    @Autowired
    private OperateLogService operateLogService;
    @Autowired
    private AppChannelService appChannelService;


    @ApiOperation(value = "操作日志列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<SysOperateLog>> getOperateLogList(@RequestBody OperateLogParam param, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        param.setChannelId(channelId);
        List<SysOperateLog> list = operateLogService.getOperateLogList(param.getPageNum(), param.getPageSize(),param);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation(value = "新增操作日志")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody SysOperateLog sysOperateLog,HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        CommonResult commonResult;
        sysOperateLog.setChannelId(channelId);
        int count = operateLogService.createOperateLog(sysOperateLog);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


}

