package my.fast.admin.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import my.fast.admin.app.common.constant.CommonPage;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.entity.AppMemberAddress;
import my.fast.admin.app.entity.AppMemberBank;
import my.fast.admin.app.model.AppMemberAddressPram;
import my.fast.admin.app.service.AppMemberAddressService;
import my.fast.admin.app.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:29
 */

@Controller
@Api(tags = "AppMemberAddressController", description = "会员收货地址管理")
@RequestMapping("/address")
public class AppMemberAddressController {
	@Autowired
	private AppMemberService appMemberService;
	
    @Autowired
    private AppMemberAddressService appMemberAddressService;

    @ApiOperation("获取所有会员地址")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMemberAddress> appMemberLevels = appMemberAddressService.listAll();
        return CommonResult.success(appMemberLevels);
    }

    @ApiOperation(value = "获取会员地址列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberAddress>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<AppMemberAddress> appMemberLevels = appMemberAddressService.listAddress(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberLevels));
    }

    @ApiOperation(value = "删除会员地址列表")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appMemberAddressService.deleteAddress(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新会员地址")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody AppMemberAddress appMemberAddress,HttpServletRequest request) {
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        CommonResult commonResult;
        int count = appMemberAddressService.updateAddress(appMemberAddress);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加会员地址")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppMemberAddressPram appMemberAddressPram) {
        CommonResult commonResult;
        int count = appMemberAddressService.createAddress(appMemberAddressPram);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "查询会员地址信息")
    @RequestMapping(value = "/getmemberaddress/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberAddress(@PathVariable("id") Long id,HttpServletRequest request) {
    	if (id==null) {
            return CommonResult.failed("会员id不为空");
        }
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        AppMemberAddress appMemberAddress = appMemberAddressService.getMemberAddress(id);
    	return CommonResult.success(appMemberAddress);
    }
    
    
    
}
