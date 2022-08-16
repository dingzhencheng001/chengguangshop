package my.fast.admin.cg.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.excel.EasyExcel;

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
    public CommonResult<CommonPage<AppGoods>> getList(@RequestBody GoodsParam goodsParam, HttpServletRequest request) {
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
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppGoods> goodsList = goodsService.listGoods(goodsParam, channelId);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
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
        if (sysChannel == null || sysChannel.getChannelId() == null) {
            return CommonResult.failed("801");
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
        if (sysChannel == null || sysChannel.getChannelId() == null) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        AppGoods appGoods = goodsService.selectById(id, channelId);
        return CommonResult.success(appGoods);
    }

    /**
     * 商品导出
     */
    @ApiOperation(value = "商品信息导出")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public CommonResult exportGoods(HttpServletResponse response, HttpServletRequest request) throws IOException {
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
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppGoods> members = goodsService.getGoods(channelId);
        // 设置文本内省
        response.setContentType("application/vnd.ms-excel");
        // 设置字符编码
        response.setCharacterEncoding("utf-8");
        // 设置响应头
        response.setHeader("Content-disposition", "attachment;filename=goods.xlsx");
        EasyExcel.write(response.getOutputStream(), AppGoods.class)
            .sheet("goods")
            .doWrite(members);
        return CommonResult.success(null);
    }

    /**
     * 从Excel导入商品信息
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult importGoodsList(@RequestPart("file") MultipartFile file, HttpServletRequest request)
    throws IOException {
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
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppGoods> list = EasyExcel.read(file.getInputStream())
            .head(AppGoods.class)
            .sheet()
            .doReadSync();
        list.stream()
            .forEach(p -> p.setChannelId(channelId));
        int count = goodsService.importGoodsList(list);
        if (count > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

}
