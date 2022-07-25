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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.service.AppMemberBankService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@Controller
@Api(tags = "AppMemberBankController", description = "APP会员银行卡信息管理")
@RequestMapping("/app/bank")
public class AppMemberBankController {
	
	@Autowired
	private AppMemberService appMemberService;
    @Autowired
    private AppMemberBankService appMemberBankService;


    @ApiOperation(value = "更新会员银行卡信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody AppMemberBank appMemberBank,HttpServletRequest request) {
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        CommonResult commonResult;
        //先根据ID查询无则新增有则更新
        AppMemberBank  tempBank = appMemberBankService.getMemberBank(appUserVO.getId());
        appMemberBank.setChannelId(appUserVO.getChannelId());//设置渠道ID
        if(tempBank == null){
        	int count = appMemberBankService.createBanks(appMemberBank);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{
        	int count = appMemberBankService.updateBanks(appMemberBank);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }
        return commonResult;
    }

    
    @ApiOperation(value = "查询会员银行卡信息")
    @RequestMapping(value = "/getmemberbank/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberBank(@PathVariable("id") Long id,HttpServletRequest request) {
    	if (id==null) {
            return CommonResult.failed("会员id不为空");
        }
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
    	AppMemberBank appMemberBank = appMemberBankService.getMemberBank(id);
    	return CommonResult.success(appMemberBank);
    }
    
    
    
    

}
