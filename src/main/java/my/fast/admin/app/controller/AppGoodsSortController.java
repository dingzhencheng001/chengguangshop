package my.fast.admin.app.controller;

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
import my.fast.admin.app.entity.AppGoodsSort;
import my.fast.admin.app.service.AppGoodsSortService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 10:32
 */
@Controller
@Api(tags = "AppGoodsSortController", description = "APP商品分类管理")
@RequestMapping("/goodsSort")
public class AppGoodsSortController {
    @Autowired
    private AppGoodsSortService appGoodsSortService;

    @ApiOperation("获取商品分类列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppGoodsSort> appGoodsSort = appGoodsSortService.listAll();
        return CommonResult.success(appGoodsSort);
    }

    @ApiOperation(value = "根据条件获取商品分类列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppGoodsSort>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize ,@RequestBody AppGoodsSort appGoodsSort ) {
        List<AppGoodsSort> goodsList = appGoodsSortService.listGoodsSort(appGoodsSort, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation(value = "删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appGoodsSortService.deleteGoodsSort(id);
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
        int count = appGoodsSortService.updateGoodsSort(id, appGoodsSort);
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
    public CommonResult create(@RequestBody AppGoodsSort appGoodsSort) {
        CommonResult commonResult;
        int count = appGoodsSortService.createGoodsSort(appGoodsSort);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}
