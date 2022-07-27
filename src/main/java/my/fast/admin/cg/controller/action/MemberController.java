package my.fast.admin.cg.controller.action;

import java.math.BigDecimal;
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
import lombok.extern.slf4j.Slf4j;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.common.constant.UserConstants;
import my.fast.admin.cg.common.utils.IPUtils;
import my.fast.admin.cg.common.utils.RequestUtil;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.MemberParam;
import my.fast.admin.cg.model.MemberParams;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.service.AppTeamReportService;
import my.fast.admin.cg.vo.AppMemberVo;
import my.fast.admin.framework.shiro.ShiroUtils;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.DateFormat;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 10:32
 */
@Slf4j
@Controller
@Api(tags = "MemberController", description = "会员管理")
@RequestMapping("/action/member")
public class MemberController {

    @RequestMapping("/list")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/list");
        return mav;
    }

		@RequestMapping("/level")
    public Object level() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("level/list");
        return mav;
    }

    @RequestMapping("/viewTeam")
    public Object viewTeam() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/viewTeam");
        return mav;
    }

    @Autowired
    private AppTeamReportService appTeamReportService;
    
    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    private AppChannelService appChannelService;


    @ApiOperation(value = "根据条件获取会员分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberVo>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, @RequestBody MemberParams memberParams,HttpServletRequest request) {
    	StringBuffer url = request.getRequestURL();  
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
        log.info("域名 ：tempContextUrl: "+  tempContextUrl);
        
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        log.info("ChannelId : "+  sysChannel.getChannelId());//对应渠道Id
        Long channelId = sysChannel.getChannelId();
        List<AppMemberVo> appMemberVoList = appMemberService.listMember(channelId,memberParams, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberVoList));
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
    public CommonResult update(@PathVariable("id") Long id, @RequestBody AppMember appMember) {
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
    public CommonResult create(@RequestBody AppMember appMember,HttpServletRequest request) {
        AppMember  tbAppUser = new  AppMember();
        tbAppUser.setUserAccount(appMember.getUserAccount());
        tbAppUser.setPhoneNumber(appMember.getPhoneNumber());
         
    	if (appMember.getParentUserId()!=null)
        {
    		AppMember parentUser =  appMemberService.selectAppMemberByUserId(appMember.getParentUserId());
    		if(parentUser==null){
        		return CommonResult.failed("添加会员" + appMember.getUserAccount() + "失败，上级会员不存在");
        	}
        	tbAppUser.setChannelId(parentUser.getChannelId()); //设置渠道id
        	tbAppUser.setParentUserId(parentUser.getId());//上级会员ID
        	tbAppUser.setParentUserName(parentUser.getUserAccount());//上级会员昵称
        	tbAppUser.setChannelId(parentUser.getChannelId()); //对应渠道Id
        }else{
        	//无上级ID 则根据当前的域名取
        	//根据域名获取渠道号
            StringBuffer url = request.getRequestURL();  
            String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
            log.info("域名 ：tempContextUrl: "+  tempContextUrl);
            
            SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
            if (sysChannel == null || sysChannel.getChannelId()==null ) {
                return CommonResult.failed("渠道查询错误，渠道ID不存在");
            }
            log.info("ChannelId : "+  sysChannel.getChannelId());
            tbAppUser.setChannelId(sysChannel.getChannelId()); //对应渠道Id
        }
    	
    	if (UserConstants.NOT_UNIQUE.equals(appMemberService.checkUserNameUnique(tbAppUser)))
        {
            return CommonResult.failed("添加会员" + appMember.getUserAccount() + "失败，该机构下此账号已存在,请直接登陆");
        }
        else if (StringUtils.isNotEmpty(appMember.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(appMemberService.checkPhoneUnique(tbAppUser)))
        {
            return CommonResult.failed("注册用户'" + appMember.getUserAccount() + "'失败，手机号码已存在,请直接登陆");
        }
    	
        //检验完成补充设置信息进行insert注册
    	tbAppUser.setMemberLevelId(1L);
    	tbAppUser.setBalance(new BigDecimal(0.00));
    	tbAppUser.setFreezeBalance(new BigDecimal(0.00));
    	tbAppUser.setRechargeNum(new BigDecimal(0.00));
    	tbAppUser.setDepositNum(new BigDecimal(0.00));
    	tbAppUser.setDeductionNum(new BigDecimal(0.00));
    	tbAppUser.setPassword(appMember.getPassword());//注册密码用户自己输入
    	tbAppUser.setIsAgent(1);
    	tbAppUser.setAgentLevel(1);
    	tbAppUser.setInviteCode(CommonUtils.getItemReCode(8)); //生成自己的邀请码 8位数字+字母
    	tbAppUser.setStatus(0);
    	tbAppUser.setDelFlag(1);
    	tbAppUser.setCreateBy("admin");//管理员注册ShiroUtils.getUserEntity().getId()
    	tbAppUser.setCreateTime(DateFormat.getNowDate());
    	tbAppUser.setMemberStatus(1);
    	tbAppUser.setRegistrationTime(DateFormat.getNowDate());
    	//注册IP  注册国家
    	String ip = RequestUtil.getRequestIp(request);
        String countryName = IPUtils.getIPMsg(ip)
            .getCountryName();
        tbAppUser.setRegisterCountry(countryName);
        tbAppUser.setRegisterIp(ip);
        tbAppUser.setRegisterIp(RequestUtil.getRequestIp(request));
    	log.info(System.currentTimeMillis() + "添加用户请求内容：", tbAppUser.getUserAccount());
        int  row =  this.appMemberService.createMember(tbAppUser); 
        log.info(System.currentTimeMillis() + "完成注册：", tbAppUser.getUserAccount());
        if (row > 0) {
        	return CommonResult.success("SUCCESS", tbAppUser.getUserAccount()+"用户添加成功!当前登录手机号为:"+tbAppUser.getPhoneNumber()+ " 渠道编号为："+tbAppUser.getChannelId());
        } else {
        	return CommonResult.failed( "添加失败，请联系管理员...");
        }
        
    }

    @ApiOperation(value = "获取会员团队信息")
    @RequestMapping(value = "/team/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppMember>> getTeamLevelList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,@RequestBody MemberParam param,HttpServletRequest request) {
    	StringBuffer url = request.getRequestURL();  
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
        log.info("域名 ：tempContextUrl: "+  tempContextUrl);
        
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        log.info("ChannelId : "+  sysChannel.getChannelId());//对应渠道Id
        param.setChannelId(sysChannel.getChannelId());
        List<AppMember> voList = appTeamReportService.getTeamLevelList(param, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(voList));
    }
    

}
