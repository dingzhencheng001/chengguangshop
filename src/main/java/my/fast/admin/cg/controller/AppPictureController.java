package my.fast.admin.cg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.entity.AppPicture;
import my.fast.admin.cg.model.PictureParam;
import my.fast.admin.cg.service.AppMemberService;
import my.fast.admin.cg.service.AppPictureService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/25 16:22
 */
@Controller
@Api(tags = "AppPictureController", description = "APP图片查询管理")
@RequestMapping("/app/picture")
public class AppPictureController {

    @Autowired
    private AppMemberService appMemberService;

    @Autowired
    private AppPictureService appPictureService;

    @ApiOperation(value = "获取app展示图片")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<AppPicture>> selectPictureList(HttpServletRequest request ,@RequestBody
        PictureParam pictureParam) {
        AppMember appUserVO = appMemberService.selectAppMemberByUserId(TokenUtils.getUserId(request)); //获取登录用户信息
        if (appUserVO == null || StringUtils.isEmpty(appUserVO.getUserAccount())) {
            return CommonResult.failed("812");
        }
        Long channelId = appUserVO.getChannelId();
        pictureParam.setChannelId(channelId);
        List<AppPicture> appPictures = appPictureService.selectPicture(pictureParam);
        return CommonResult.success(appPictures);

    }

}
