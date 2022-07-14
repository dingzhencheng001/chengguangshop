package my.fast.admin.app.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
import my.fast.admin.app.entity.AppMemberLevel;
import my.fast.admin.app.service.AppMemberLevelService;
import my.fast.admin.app.service.AppMemberService;
import my.fast.admin.app.vo.AppMemberVo;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Controller
@Api(tags = "AppMemberController", description = "会员管理")
@RequestMapping("/member")
public class AppMemberController {
	@Autowired
	private AppMemberService appMemberService;

	@Autowired
	private AppMemberLevelService appMemberLevelService;
	
	
    @ApiOperation("获取会员列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMember> appMember = appMemberService.listAll();
        return CommonResult.success(appMember);
    }

    @ApiOperation(value = "根据条件获取会员分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMember>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize ,@RequestBody AppMember appMember) {
        List<AppMember> appMemberList = appMemberService.listMember(appMember, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberList));
    }

    
    @ApiOperation(value = "删除会员")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appMemberService.deleteMemberById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新会员")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppMember appMember) {
        CommonResult commonResult;
        int count = appMemberService.updateMember(id, appMember);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加会员")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppMember appMember) {
        CommonResult commonResult;
        int count = appMemberService.createMember(appMember);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
    
    
    
    
    
    @ApiOperation(value = "首页信息")
    @RequestMapping(value = "/homePage", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult homePage(HttpServletRequest request) {
    	 
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户未登录");
        }
        AppMemberVo  reVo =  new AppMemberVo();
        AppMember voInfo = appMemberService.selectAppMemberByUserId(appUserVO.getId());
        if (voInfo == null) {
        	return CommonResult.failed("用户信息不存在");
        } 
        BeanUtils.copyProperties(voInfo, reVo);
        //首页设置余额
        reVo.setBalance(voInfo.getBalance());
        //今日佣金 -- 根据用户ID 从账变表 类型为佣金 取今日数据累加 TODO= 账变表字段加类型
        reVo.setTodaySum(new BigDecimal(0));
        //总佣金
        reVo.setTotalCommission(voInfo.getTotalCommission());;
        
        //会员等级List
        List<AppMemberLevel> levelList = appMemberLevelService.listAll();
        if (levelList == null) {
        	return CommonResult.failed("会员等级数据异常");
        } 
        reVo.setLevelList(levelList);
        
        //代理收益列表获取 ? 查找逻辑是 我的上级代理还是下级代理 ？
        //	TODO=
        
        return CommonResult.success(reVo);
    }
    
    
    
    
    @ApiOperation(value = "会员信息")
    @RequestMapping(value = "/memberInfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult memberInfo(HttpServletRequest request) {
    	 
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("用户信息不存在");
        }
        
        AppMember voInfo = appMemberService.selectAppMemberByUserId(appUserVO.getId());
        if (voInfo == null) {
        	return CommonResult.failed("用户信息不存在");
        } 
        
        return CommonResult.success(voInfo);
    }
    

}
