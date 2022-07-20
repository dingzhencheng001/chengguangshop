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
import my.fast.admin.app.entity.AppConvey;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.service.AppConveyService;
import my.fast.admin.app.service.AppMemberService;
import my.fast.admin.app.vo.AppConveyDto;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Controller
@Api(tags = "AppConveyController", description = "交易订单管理")
@RequestMapping("/convey")
public class AppConveyController {
	
    @Autowired
    private AppConveyService appConveyService;

	@Autowired
	private AppMemberService appMemberService;
    
    @ApiOperation("获取交易订单列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppConvey> appConvey = appConveyService.listAll();
        return CommonResult.success(appConvey);
    }

    @ApiOperation(value = "根据条件获取订单分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppConveyDto>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize ,@RequestBody AppConvey appConvey,HttpServletRequest request) {
        
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        appConvey.setMemberId(appUserVO.getId());
    	List<AppConveyDto> conveyList = appConveyService.listConvey(appConvey, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(conveyList));
    }

    
    @ApiOperation(value = "删除交易订单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appConveyService.deleteConveyById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新交易订单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppConvey appConvey) {
        CommonResult commonResult;
        int count = appConveyService.updateConvey(id, appConvey);
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
    public CommonResult create(@RequestBody AppConvey appConvey) {
        CommonResult commonResult;
        int count = appConveyService.createConvey(appConvey);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}
