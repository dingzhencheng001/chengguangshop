package my.fast.admin.cg.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.common.constant.RedisKeyConstant;
import my.fast.admin.cg.common.constant.UserConstants;
import my.fast.admin.cg.common.utils.IPUtils;
import my.fast.admin.cg.common.utils.RequestUtil;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.DateFormat;
import my.fast.admin.framework.utils.Md5;
import my.fast.admin.framework.utils.TokenUtils;

@Slf4j
@Controller
@Api(tags = "AppLoginController", description = "APP登陆管理")
@RequestMapping("/app/user/login")
public class AppLoginController {

	
    @Value("${token.timeout:360}")
    private Integer tokenTime;
    
    @Autowired
    private AppMemberService appMemberService;
    
    @Autowired
    private AppChannelService appChannelService;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @SuppressWarnings("rawtypes")
	@ApiOperation("登录")
    @PostMapping("/applogin")
    @ResponseBody
    public CommonResult login(@RequestBody AppMember  loginVO,HttpServletRequest request) {
        log.info("[0xCUC47130]登陆请求内容：{}", loginVO == null ? null : loginVO.toString());
        CommonResult commonResult;
        if (loginVO == null || StringUtils.isEmpty(loginVO.getPhoneNumber()) || StringUtils.isEmpty(loginVO.getPassword())) {
            return CommonResult.failed("800");
        }
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();  
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();  
        log.info("域名 ：tempContextUrl: "+  tempContextUrl);
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        log.info(sysChannel.getChannelId() + sysChannel.getAppDns());
        loginVO.setChannelId(sysChannel.getChannelId());
        AppMember appUserVO = appMemberService.selectAppMemberByUserPhone(loginVO);
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount()) ) {
            return CommonResult.failed("802");
        }
        if (appUserVO.getStatus() != 0 ) {
            return CommonResult.failed("803");
        }
        if (appUserVO.getMemberStatus() != 1  ) {
            return CommonResult.failed("804");
        }
        //后续加上密码加密串字段salt
//        SimpleHash password = new SimpleHash("MD5", appUserVO.getPassword(), appUserVO.get);
//        if (!password.toString().equals(loginVO.getPassword())) {
//        	return CommonResult.failed( "805");
//        }
        if (!loginVO.getPassword().equals(appUserVO.getPassword())) {
            return CommonResult.failed( "805");
        }
        Map<String, Object> resultMap  = loginAction(appUserVO,request);
        commonResult = CommonResult.success(resultMap);
        return commonResult;
    }

	
    /**
     * 登录
     * @param appUserVO
     * @param request
     * @return
     */
    private Map<String, Object> loginAction(AppMember appUserVO, HttpServletRequest request) {
    	log.info(System.currentTimeMillis() +"执行登陆方法{}", appUserVO.getUserAccount());
//      Assert.isTrue("0" .equals(appUserVO.getStatus().toString()) , "账号已禁用");
        String username = appUserVO.getUserAccount();
        Map<String, Object> resultMap = new HashMap<>(8);
        Map<String, Object> claims = new HashMap<>(8);
        claims.put("username", username);
        claims.put("mobile", appUserVO.getPhoneNumber());
        claims.put("userid", appUserVO.getId());
        String md5 = Md5.md5Digest(appUserVO.getId().toString() + System.currentTimeMillis()).toLowerCase();
        String token = appUserVO.getId() + "-" + md5.substring(0, 16) + "-" + md5.substring(16, 32);
        
        redisTemplate.opsForValue().set(RedisKeyConstant.LOGIN_TOKEN + token, RedisKeyConstant.LOGIN_TOKEN + username, tokenTime, TimeUnit.MINUTES);
        //同一账号只能一处登录
        redisTemplate.delete(RedisKeyConstant.LOGIN_TOKEN + username);
        claims.put("token", token);
        redisTemplate.opsForHash().putAll(RedisKeyConstant.LOGIN_TOKEN + username, claims);
        redisTemplate.expire(RedisKeyConstant.LOGIN_TOKEN + username, tokenTime, TimeUnit.MINUTES);
        resultMap.put("token", token);
        //更新登录时间 TODO 登陆IP等获取
//        log.info(System.currentTimeMillis() + " 登陆完成,更新登陆时间" );
        appUserVO.setLoginDate(new Date());
        appUserVO.setLoginIp(RequestUtil.getRequestIp(request));
        appMemberService.updateMember(appUserVO.getId(), appUserVO);
        resultMap.put("user", appUserVO);
        System.out.println(token);
        System.out.println((System.currentTimeMillis() + " 登陆完成返回 token ："+  appUserVO.getUserAccount() + " : " + token));
        return resultMap;
    }

    
    @ApiOperation("帐号注册")
    @PostMapping("/registry")
    @ResponseBody
    public CommonResult registry(@RequestBody AppMember userLoginVO,HttpServletRequest request) {
        log.info("[0xCUC50130]请求内容：{}", userLoginVO == null ? null : userLoginVO.toString());
        if (userLoginVO == null || StringUtils.isEmpty(userLoginVO.getUserAccount()) || StringUtils.isEmpty(userLoginVO.getPassword())) {
            return CommonResult.failed("806");
        }
        //设置处理对象
        AppMember  tbAppUser = new  AppMember();
        tbAppUser.setUserAccount(userLoginVO.getUserAccount());
        tbAppUser.setPhoneNumber(userLoginVO.getPhoneNumber());
        tbAppUser.setEmail(userLoginVO.getEmail());
    	if (StringUtils.isEmpty(userLoginVO.getInviteCode()))
        {
            return CommonResult.failed("807");
        }
    	AppMember  parentUser =  appMemberService.selectAppMemberByCode(userLoginVO.getInviteCode());
    	if(parentUser==null){
    		return CommonResult.failed("808");
    	}
    	tbAppUser.setChannelId(parentUser.getChannelId()); //设置渠道id
    	if (UserConstants.NOT_UNIQUE.equals(appMemberService.checkUserNameUnique(tbAppUser)))
        {
            return CommonResult.failed("809");
        }
        else if (StringUtils.isNotEmpty(userLoginVO.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(appMemberService.checkPhoneUnique(tbAppUser)))
        {
            return CommonResult.failed("810");
        }
        //检验完成补充设置信息进行insert注册
    	tbAppUser.setMemberLevelId(1L);
    	tbAppUser.setBalance(new BigDecimal(0.00));
    	tbAppUser.setFreezeBalance(new BigDecimal(0.00));
    	tbAppUser.setRechargeNum(new BigDecimal(0.00));
    	tbAppUser.setDepositNum(new BigDecimal(0.00));
    	tbAppUser.setDeductionNum(new BigDecimal(0.00));
    	//设定余额必须 大于 限制交易金额 默认100
    	tbAppUser.setLimitAmount(new BigDecimal(100.00));
    	tbAppUser.setDrawalStatus(0);//0.正常 1.禁止提现
    	tbAppUser.setPassword(userLoginVO.getPassword());//注册密码用户自己输入
    	tbAppUser.setParentUserId(parentUser.getId());//上级会员ID
    	tbAppUser.setParentUserName(parentUser.getUserAccount());//上级会员昵称
    	tbAppUser.setChannelId(parentUser.getChannelId()); //对应渠道Id
    	tbAppUser.setIsAgent(1);
    	tbAppUser.setAgentLevel(1);
    	tbAppUser.setInviteCode(CommonUtils.getItemReCode(8)); //生成自己的邀请码 8位数字+字母
    	tbAppUser.setStatus(0);
    	tbAppUser.setDelFlag(1);
    	tbAppUser.setCreateBy(tbAppUser.getUserAccount());//自己本人注册
    	tbAppUser.setCreateTime(DateFormat.getNowDate());
    	tbAppUser.setMemberStatus(1);//1.真人 2 假人
    	tbAppUser.setRegistrationTime(DateFormat.getNowDate());
    	//注册IP  注册国家
        String ip = RequestUtil.getRequestIp(request);
        String countryName = IPUtils.getIPMsg(ip)
            .getCountryName();
        tbAppUser.setRegisterCountry(countryName);
        tbAppUser.setRegisterIp(ip);
    	log.info(System.currentTimeMillis() + "注册用户请求内容：", tbAppUser.getUserAccount());
        int  row =  this.appMemberService.createMember(tbAppUser); 
        log.info(System.currentTimeMillis() + "完成注册：", tbAppUser.getUserAccount());
        if (row > 0) {
        	return CommonResult.success("SUCCESS", tbAppUser.getUserAccount()+"User registration succeeded! The current login mobile phone number is::"+tbAppUser.getPhoneNumber()+ " Channel number:："+tbAppUser.getChannelId());
        } else {
        	return CommonResult.failed( "Registration failed, please contact the Administrator");
        }
    }

    
    /**
     * 用户修改登录密码
     * @param request HttpServletRequest
     * @param oldPwd  旧密码
     * @param newPwd  新密码
     * @return MessageResult
     */
    @ApiOperation("修改登录密码")
    @PostMapping("/update/pwd")
    @ResponseBody
    public CommonResult updatePwd(HttpServletRequest request, @RequestParam("oldPwd") String oldPwd,
                                   @RequestParam("newPwd") String newPwd, @RequestParam("token") String token) {
    	//APP已登录用户 需带token 访问；根据token 获取用户信息 再做业务逻辑操作
    	AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if(appUserVO==null || StringUtils.isEmpty(appUserVO.getUserAccount())){
        	return CommonResult.failed("813");
        }
    	Assert.isTrue(StringUtils.isNotBlank(oldPwd), "Please enter your old password");
        Assert.isTrue(StringUtils.isNotBlank(newPwd), "Please enter a new password");
        Assert.isTrue(!oldPwd.equals(newPwd), "The old and new passwords are consistent");
        Assert.isTrue(newPwd.matches("[a-zA-Z0-9]+"), "Please enter a combination of 8-32 digits and letters");
        Assert.isTrue(newPwd.length() >= 8 && newPwd.length() <= 32, "Please enter a combination of 8-32 digits and letters");
        Assert.isTrue(newPwd.length() >= 6 && newPwd.length() <= 32, "Please enter a 6-32-bit password");
        Assert.isTrue(newPwd.length() >= 6, "Password cannot be less than 6 digits, please re-enter");
//        if (!CommonUtils.matchesPassword(oldPwd, appUserVO.getPassword())) {
//            return CommonResult.failed("811");
//        }
        if (!oldPwd.equals(appUserVO.getPassword())) {
          return CommonResult.failed("811");
        }
        appUserVO.setPassword(newPwd);
        int  row =  appMemberService.updateMember(appUserVO.getId(), appUserVO);
        if (row > 0) {
        	return CommonResult.success("SUCCESS", "Password modification completed");
        } else {
        	return CommonResult.failed("Password modification failed, please contact administrator");
        }
        
    }
    
	
}
