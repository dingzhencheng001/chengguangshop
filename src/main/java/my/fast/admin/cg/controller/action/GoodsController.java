package my.fast.admin.cg.controller.action;

import java.math.BigDecimal;
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
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.cg.common.constant.CommonPage;
import my.fast.admin.cg.common.constant.CommonResult;
import my.fast.admin.cg.entity.AppGoods;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.AppGoodsParam;
import my.fast.admin.cg.model.GoodsParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.GoodsService;
import my.fast.admin.framework.utils.DateFormat;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:32
 */
@Controller
@Api(tags = "GoodsController", description = "商品管理")
@RequestMapping("/action/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AppChannelService appChannelService;

    @RequestMapping("/lists")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("goods/list");
        return mav;
    }

    @RequestMapping("/classify")
    public Object classify() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("goods/classify");
        return mav;
    }

    @ApiOperation(value = "根据条件获取商品列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppGoods>> getList(
     @RequestBody GoodsParam goodsParam, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppGoods> goodsList = goodsService.listGoods(goodsParam, channelId);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id ) {
        int count = goodsService.deleteGoods(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新商品信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody AppGoods appGoods) {
        CommonResult commonResult;
        int count = goodsService.updateGoods(id, appGoods);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody AppGoodsParam appGoodsParam, HttpServletRequest request) {
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
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        int count = goodsService.createGoods(appGoodsParam, channelId);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "根据id查询商品信息")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@PathVariable("id") Long id, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI()
            .length(), url.length())
            .append(request.getServletContext()
                .getContextPath())
            .append("/")
            .toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        AppGoods appGoods = goodsService.selectById(id,channelId);
        return CommonResult.success(appGoods);
    }

}
