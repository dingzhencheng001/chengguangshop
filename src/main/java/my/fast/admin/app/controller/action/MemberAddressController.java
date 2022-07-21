package my.fast.admin.app.controller.action;

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
import my.fast.admin.app.common.constant.CommonPage;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppMemberAddress;
import my.fast.admin.app.service.AppMemberAddressService;
/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 16:29
 */

@Controller
@Api(tags = "MemberAddressController", description = "会员收货地址管理")
@RequestMapping("/addressaction")
public class MemberAddressController {
	
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

    @ApiOperation(value = "新增/更新会员地址")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult save(@RequestBody AppMemberAddress appMemberAddress,HttpServletRequest request) {
    	CommonResult commonResult;
        if(appMemberAddress.getId() == null){//新增
        	int count = appMemberAddressService.createAddress(appMemberAddress);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{ //修改
        	int count = appMemberAddressService.updateAddress(appMemberAddress);
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
        AppMemberAddress appMemberAddress = appMemberAddressService.getMemberAddress(id);
    	return CommonResult.success(appMemberAddress);
    }
    
    
}
