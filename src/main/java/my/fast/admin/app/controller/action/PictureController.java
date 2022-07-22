package my.fast.admin.app.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
import my.fast.admin.app.entity.AppPicture;
import my.fast.admin.app.service.AppNoticeService;
import my.fast.admin.app.service.PictureService;
import my.fast.admin.framework.utils.TokenUtils;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/21 11:39
 */
@Controller
@Api(tags = "PictureController", description = "图片管理")
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @ApiOperation("获取所有图片")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppPicture> appPictures = pictureService.listAll();
        return CommonResult.success(appPictures);
    }
    
    @ApiOperation(value = "分页查询图片列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppPicture>> getPictureList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<AppPicture> appPictureList = pictureService.getPictureList(
            pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appPictureList));
    }

    @ApiOperation(value = "删除图片")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = pictureService.deletePictureById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "添加图片信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody AppPicture appPicture) {
        CommonResult commonResult;
        int count = pictureService.createPicture(appPicture);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "更新图片信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppPicture appPicture) {
        CommonResult commonResult;
        int count = pictureService.updatePicture(id, appPicture);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }




}
