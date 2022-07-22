package my.fast.admin.app.controller.action;

import java.math.BigDecimal;
import java.util.List;

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
import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.model.AppGoodsParam;
import my.fast.admin.app.service.AppGoodsService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:32
 */
@Controller
@Api(tags = "GoodsController", description = "商品管理")
@RequestMapping("/goodsaction")
public class GoodsController {
    @Autowired
    private AppGoodsService appGoodsService;

    @ApiOperation("获取商品列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppGoods> appGoods = appGoodsService.listAll();
        return CommonResult.success(appGoods);
    }

    @ApiOperation(value = "根据条件获取商品列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppGoods>> getList(
        @RequestParam(value = "goodsName", required = false) String goodsName,
        @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
        @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<AppGoods> goodsList = appGoodsService.listGoods(goodsName, pageNum, pageSize, minPrice,
            maxPrice);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appGoodsService.deleteGoods(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody AppGoodsParam appGoodsParam) {
        CommonResult commonResult;
        int count = appGoodsService.updateGoods(id, appGoodsParam);
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
    public CommonResult create(@RequestBody AppGoodsParam appGoodsParam) {
        CommonResult commonResult;
        int count = appGoodsService.createGoods(appGoodsParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}
