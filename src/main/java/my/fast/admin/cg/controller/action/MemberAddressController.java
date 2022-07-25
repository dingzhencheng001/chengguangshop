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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.MemberAddressParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.MemberAddressService;
/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:29
 */
@Slf4j
@Controller
@Api(tags = "MemberAddressController", description = "会员收货地址管理")
@RequestMapping("/address/action")
public class MemberAddressController {
	
    @Autowired
    private MemberAddressService memberAddressService;

    @Autowired
    private AppChannelService appChannelService;

    @ApiOperation(value = "获取会员地址列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberAddress>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, @RequestBody MemberAddressParam  param,HttpServletRequest request) {
    	StringBuffer url = request.getRequestURL();  
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
        log.info("域名 ：tempContextUrl: "+  tempContextUrl);
        
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        log.info("ChannelId : "+  sysChannel.getChannelId());//对应渠道Id
        param.setChannelId(sysChannel.getChannelId());
        List<AppMemberAddress> appMemberLevels = memberAddressService.listAddress(param,pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberLevels));
    }

    @ApiOperation(value = "删除会员地址列表")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = memberAddressService.deleteAddress(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "新增/更新会员地址")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult save(@RequestBody AppMemberAddress appMemberAddress,HttpServletRequest request) {
    	CommonResult commonResult;
    	StringBuffer url = request.getRequestURL();  
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
        log.info("域名 ：tempContextUrl: "+  tempContextUrl);
        
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        log.info("ChannelId : "+  sysChannel.getChannelId());//对应渠道Id
        appMemberAddress.setChannelId(sysChannel.getChannelId());
    	AppMemberAddress tempAddress = memberAddressService.getMemberAddress(appMemberAddress.getMemberId());
        if(tempAddress == null ){//新增
        	int count = memberAddressService.createAddress(appMemberAddress);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{ //修改
        	if(appMemberAddress.getId()==null){
        		appMemberAddress.setId(tempAddress.getId());
        	}
        	int count = memberAddressService.updateAddress(appMemberAddress);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }
        return commonResult;
    }

    

    @ApiOperation(value = "查询会员地址信息")
    @RequestMapping(value = "/getmemberaddress/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberAddress(@PathVariable("id") Long id,HttpServletRequest request) {
        AppMemberAddress appMemberAddress = memberAddressService.getMemberAddress(id);
    	return CommonResult.success(appMemberAddress);
    }
    
    
}
