package my.fast.admin.cg.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.sun.org.apache.regexp.internal.RE;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberAddress;
import my.fast.admin.cg.service.AppMemberAddressService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:29
 */

@Controller
@Api(tags = "AppMemberAddressController", description = "APP会员收货地址管理")
@RequestMapping("/app/address")
public class AppMemberAddressController {
	@Autowired
	private AppMemberService appMemberService;
	
    @Autowired
    private AppMemberAddressService appMemberAddressService;


    @ApiOperation(value = "更新会员地址")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody AppMemberAddress appMemberAddress,HttpServletRequest request) {
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        //先根据ID查询无则新增有则更新
        AppMemberAddress tempAddress = appMemberAddressService.getMemberAddress(appUserVO.getId());
        appMemberAddress.setChannelId(appUserVO.getChannelId());//设置渠道ID
        appMemberAddress.setMemberId(appUserVO.getId());//设置会员ID
        int count;
        if(tempAddress == null){
            count = appMemberAddressService.createAddress(appMemberAddress);
        }else{
            count = appMemberAddressService.updateAddress(appMemberAddress);
        }
        return CommonResult.success(count);
    }

    @ApiOperation(value = "查询会员地址信息")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberAddress(@PathVariable("id") Long id,HttpServletRequest request) {
    	if (id==null) {
            return CommonResult.failed("815");
        }
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        AppMemberAddress appMemberAddress = appMemberAddressService.getMemberAddress(id);
    	return CommonResult.success(appMemberAddress);
    }
    
    
    
}
