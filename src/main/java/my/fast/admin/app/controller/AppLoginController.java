package my.fast.admin.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.common.constant.RedisKeyConstant;
import my.fast.admin.app.common.constant.UserConstants;
import my.fast.admin.app.entity.AppMember;
import my.fast.admin.app.service.AppMemberService;
import my.fast.admin.framework.log.WebLogAspect;
import my.fast.admin.framework.utils.CommonUtils;
import my.fast.admin.framework.utils.Md5;

@Slf4j
@Controller
@Api(tags = "AppLoginController", description = "登陆管理")
@RequestMapping("/appuser/login")
public class AppLoginController {

//	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
    @Value("${token.timeout:360}")
    private Integer tokenTime;
	
//    @Autowired
//    private ITbAppUserService tbAppUserService;
    
    @Autowired
    private AppMemberService appMemberService;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    /**
     * @param appMemberVo 用户登录VO
     * @return CommonResult
     */
    //@ApiOperation("登录")
    @PostMapping("/applogin")
    public CommonResult login(@RequestBody AppMember appMemberVo) {
        log.info("登录接口接收参数appMemberVo{}---------------", appMemberVo);
        //Assert.notNull(VO.getLoginType(), "登录类型为空");
        //Byte loginType = userLoginVO.getLoginType(); TODO 扩展登陆类型
        return loginWithAccount(appMemberVo);
    }

    private CommonResult loginWithAccount(AppMember loginVO) {
        log.info("[0xCUC47130]登陆请求内容：{}", loginVO == null ? null : loginVO.toString());
        if (loginVO == null || StringUtils.isEmpty(loginVO.getUserAccount()) || StringUtils.isEmpty(loginVO.getPassword())) {
            return CommonResult.failed("帐号密码不能为空");
        }
        
        AppMember appUserVO = new AppMember();// tbAppUserService.selectTbAppUserByUserName(loginVO.getUserAccount());

        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount()) ) {
        	CommonResult.failed("0xCUC47451");
            return CommonResult.failed("帐号不存在");
        }
        
        if (!CommonUtils.matchesPassword(loginVO.getPassword(), appUserVO.getPassword())) {//!password.equals(appUserVO.getPassword())
            return CommonResult.failed( "密码错误");
        }
        
        return loginAction(appUserVO);
    }

	
    /**
     * 登录
     *
     * @param fdBaseUserVO FdBaseUserVO
     * @return MessageResult
     */
    private CommonResult loginAction(AppMember appUserVO) {
    	log.info(System.currentTimeMillis() +"执行登陆方法{}", appUserVO.getUserAccount());
        Assert.isTrue("0" .equals(appUserVO.getStatus()) , "账号已禁用");
        String username = appUserVO.getUserAccount();
        Map<String, Object> resultMap = new HashMap<>(8);
        Map<String, Object> claims = new HashMap<>(8);
        claims.put("username", username);
        claims.put("mobile", appUserVO.getPhoneNumber());
        claims.put("userid", appUserVO.getId());
        String md5 = Md5.md5Digest(appUserVO.getId().toString() + System.currentTimeMillis()).toLowerCase();
        String token = appUserVO.getId() + "-" + md5.substring(0, 16) + "-" + md5.substring(16, 32);
        //String token = JWTUtils.createJWT(claims, null, tokenTime * 60 * 1000);
        redisTemplate.opsForValue().set(RedisKeyConstant.LOGIN_TOKEN + token, RedisKeyConstant.LOGIN_TOKEN + username, tokenTime, TimeUnit.MINUTES);
        //同一账号只能一处登录
        redisTemplate.delete(RedisKeyConstant.LOGIN_TOKEN + username);
        claims.put("token", token);
        redisTemplate.opsForHash().putAll(RedisKeyConstant.LOGIN_TOKEN + username, claims);
        redisTemplate.expire(RedisKeyConstant.LOGIN_TOKEN + username, tokenTime, TimeUnit.MINUTES);
        resultMap.put("token", token);
        //更新登录时间 TODO 登陆IP等获取
        log.info(System.currentTimeMillis() + " 登陆完成,更新登陆时间" );
        appUserVO.setLoginDate(new Date());
//        tbAppUserService.updateTbAppUser(appUserVO);  TODO=
        resultMap.put("user", appUserVO);
        log.info(System.currentTimeMillis() + " 登陆完成返回 token ：",  appUserVO.getUserAccount() + " : " + token);
        return CommonResult.success(resultMap);
    }

    
    
    //@ApiOperation("帐号注册")
    @PostMapping("/registry")
    public CommonResult registry(@RequestBody AppMember userLoginVO) {
        log.info("[0xCUC50130]请求内容：{}", userLoginVO == null ? null : userLoginVO.toString());
        if (userLoginVO == null || StringUtils.isEmpty(userLoginVO.getUserAccount()) || StringUtils.isEmpty(userLoginVO.getPassword())) {
            return CommonResult.failed("注册的帐号密码不能为空");
        }
        /*Byte loginType = loginVO.getLoginType();
        if (loginType == null || loginType != UserConstant.LOGIN_TYPE_USERNAME) {
            return AjaxResult.error("0xCUC50651", "登陆校验类型错误");
        }*/
        //String password = userLoginVO.getPassword();
        /*String decryptData;
        try {
            decryptData = RSA.decrypt(password, RSA.getPrivateKey(loginRsaPrivateKey));
        } catch (Exception e) {
            log.error("[0xCUC51035]密码格式有误,{},{}", password, userLoginVO.getUsername(), e);
            return AjaxResult.error("0xCUC51051", "密码格式有误");
        }*/
        
        //设置处理对象
        AppMember  tbAppUser = new  AppMember();
        tbAppUser.setUserAccount(userLoginVO.getUserAccount());
        tbAppUser.setNickName(userLoginVO.getNickName());
        tbAppUser.setPhoneNumber(userLoginVO.getPhoneNumber());
        tbAppUser.setEmail(userLoginVO.getEmail());
        
    	if (StringUtils.isEmpty(userLoginVO.getInviteCode()))
        {
            return CommonResult.failed("注册用户'" + userLoginVO.getUserAccount() + "'失败，邀请码失效或不存在");
        }
    	AppMember  parentUser = new AppMember(); // tbAppUserService.selectTbAppUserByReCode(userLoginVO.getInviteCode());TODO=
    	if(parentUser==null || StringUtils.isEmpty(parentUser.getNickName())){
    		return CommonResult.failed("注册用户'" + userLoginVO.getUserAccount() + "'失败，邀请码用户已注销或不存在");
    	}
    	
//    	if (UserConstants.NOT_UNIQUE.equals(tbAppUserService.checkUserNameUnique(userLoginVO.getUserAccount())))
//        {
//            return CommonResult.failed("注册用户'" + userLoginVO.getUserAccount() + "'失败，账号已存在,请直接登陆");
//        }
//        else if (StringUtils.isNotEmpty(userLoginVO.getPhoneNumber())
//                && UserConstants.NOT_UNIQUE.equals(tbAppUserService.checkPhoneUnique(tbAppUser)))
//        {
//            return CommonResult.failed("注册用户'" + userLoginVO.getUserAccount() + "'失败，手机号码已存在,请直接登陆");
//        }
//        else if (StringUtils.isNotEmpty(userLoginVO.getEmail())
//                && UserConstants.NOT_UNIQUE.equals(tbAppUserService.checkEmailUnique(tbAppUser)))
//        {
//            return CommonResult.failed("注册用户'" + userLoginVO.getUserAccount() + "'失败，邮箱账号已存在,请直接登陆");
//        }
    	
        //检验完成补充设置信息进行insert注册
    	tbAppUser.setPassword(CommonUtils.encryptPassword(userLoginVO.getPassword()));//注册密码用户自己输入
    	tbAppUser.setParentUserId(parentUser.getId());//上级会员ID
    	tbAppUser.setParentUserName(parentUser.getNickName());//上级会员昵称
//    	tbAppUser.setIsAgent("1");
//    	tbAppUser.setAgentLevel("1");
    	tbAppUser.setInviteCode(CommonUtils.getItemReCode(8)); //生成自己的邀请码 8位数字+字母
    	tbAppUser.setStatus(0);
//    	tbAppUser.setDelFlag("0");
    	tbAppUser.setCreateBy(tbAppUser.getUserAccount());//自己本人注册
    	log.info(System.currentTimeMillis() + "注册用户请求内容：", tbAppUser.getUserAccount());
        int  row =  1 ;//this.tbAppUserService.insertTbAppUser(tbAppUser); TODO=
        log.info(System.currentTimeMillis() + "完成注册：", tbAppUser.getUserAccount());
        if (row > 0) {
        	return CommonResult.success("SUCCESS", "注册成功!当前用户账号为:"+tbAppUser.getUserAccount());
        } else {
        	return CommonResult.failed( "注册失败，请联系管理员...");
        }
            
    }

    
    /**
     * 用户修改登录密码
     *
     * @param request HttpServletRequest
     * @param oldPwd  旧密码
     * @param newPwd  新密码
     * @return MessageResult
     */
    //@ApiOperation("修改登录密码")
    @PostMapping("/update/pwd")
    public CommonResult updatePwd(HttpServletRequest request, @RequestParam("oldPwd") String oldPwd,
                                   @RequestParam("newPwd") String newPwd, @RequestParam("token") String token) {
        
    	//APP已登录用户 需带token 访问；根据token 获取用户信息 再做业务逻辑操作
//    	Object obj = redisTemplate.opsForValue().get(token);
//    	String username = redisTemplate.opsForValue().get(RedisKeyConstant.LOGIN_TOKEN+token).toString();
    	//Map<String, Object> resultMap = (Map<String, Object>) redisTemplate.boundHashOps(username);
/*    	Long userId = TokenUtils.getUserId(request);
    	System.out.println(userId);
        TbAppUser appUserVO = tbAppUserService.selectTbAppUserByUserId(userId);*/
        
    	AppMember appUserVO = new AppMember(); // tbAppUserService.selectTbAppUserByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        
//        if(StringUtils.isNull(appUserVO)){
//        	return CommonResult.failed("用户信息不存在");
//        }
    	Assert.isTrue(StringUtils.isNotBlank(oldPwd), "请输入旧密码");
        Assert.isTrue(StringUtils.isNotBlank(newPwd), "请输入新密码");
        Assert.isTrue(!oldPwd.equals(newPwd), "新旧密码一致");
        Assert.isTrue(newPwd.matches("[a-zA-Z0-9]+"), "请输入8-32位数字、字母组合");
        Assert.isTrue(newPwd.length() >= 8 && newPwd.length() <= 32, "请输入8-32位数字、字母组合");
        Assert.isTrue(newPwd.length() >= 6 && newPwd.length() <= 32, "请输入6-32位密码");
        Assert.isTrue(newPwd.length() >= 6, "密码不能少于6位，请重新输入");
        
        if (!CommonUtils.matchesPassword(oldPwd, appUserVO.getPassword())) {
            return CommonResult.failed("旧密码输入错误");
        }
        appUserVO.setPassword(CommonUtils.encryptPassword(newPwd));
        int  row = 1; // tbAppUserService.updateTbAppUser(appUserVO); TODO=
        
        if (row > 0) {
        	return CommonResult.success("SUCCESS", "密码修改完成");
        } else {
        	return CommonResult.failed("密码修改失败，请联系管理员...");
        }
        
    }
    
	
}
