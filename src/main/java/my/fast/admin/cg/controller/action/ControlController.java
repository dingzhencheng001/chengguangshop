package my.fast.admin.cg.controller.action;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppControl;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.ControlService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@Controller
@Api(tags = "ControlController", description = "交易控制管理")
@RequestMapping("/action/control")
public class ControlController {
	
    @Autowired
    private ControlService controlService;

    @Autowired
    private AppChannelService appChannelService;


		@RequestMapping("/lists")
    public Object lists() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("transactionControl/transactionControl");
        return mav;
    }


    @ApiOperation(value = "获取渠道交易控制信息")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getControl(HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        AppControl control = controlService.getControl(channelId);
        return CommonResult.success(control);
    }

    @ApiOperation(value = "添加/更新交易控制信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult save(@RequestBody AppControl control,HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        CommonResult commonResult;
        AppControl tempControl = controlService.getControl(channelId);
        if(tempControl == null){//新增
            int count = controlService.createControl(control,channelId);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{//更新
            if(control.getId()==null){
            	control.setId(tempControl.getId());
            }
            int count = controlService.updateControl(control, channelId);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }
        return commonResult;
    }
    

}
