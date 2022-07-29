package my.fast.admin.cg.controller.action;

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
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppGoodsSort;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.GoodsSortParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.GoodsSortService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:32
 */
@Controller
@Api(tags = "GoodsSortController", description = "商品分类后台管理")
@RequestMapping("/action/goods/sort")
public class GoodsSortController {
    @Autowired
    private GoodsSortService goodsSortService;

    @Autowired
    private AppChannelService appChannelService;

    @ApiOperation("获取商品分类列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppGoodsSort> appGoodsSort = goodsSortService.listAll();
        return CommonResult.success(appGoodsSort);
    }

    @ApiOperation(value = "根据条件获取商品分类列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppGoodsSort>> getList(HttpServletRequest request,@RequestBody
        GoodsSortParam goodsSortParam ) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId() == null) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppGoodsSort> goodsList = goodsSortService.listGoodsSort(goodsSortParam,channelId);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation(value = "删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = goodsSortService.deleteGoodsSort(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppGoodsSort appGoodsSort) {
        CommonResult commonResult;
        int count = goodsSortService.updateGoodsSort(id, appGoodsSort);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加商品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppGoodsSort appGoodsSort ,HttpServletRequest request) {
        CommonResult commonResult;
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId() == null) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        int count = goodsSortService.createGoodsSort(appGoodsSort,channelId);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
    @ApiOperation(value = "根据id查找商品分类信息")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult selectById(@PathVariable("id") Long id) {
        AppGoodsSort appGoodsSort = goodsSortService.selectById(id);
        return CommonResult.success(appGoodsSort);
    }

}
