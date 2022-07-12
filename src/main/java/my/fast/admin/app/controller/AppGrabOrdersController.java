package my.fast.admin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppGoods;
import my.fast.admin.app.model.AppRandomOrderPram;
import my.fast.admin.app.service.AppGrabOrdersService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 14:56
 */

@Controller
@Api(tags = "AppGrabOrdersController", description = "抢单管理")
@RequestMapping("/grab")
public class AppGrabOrdersController {
    @Autowired
    private AppGrabOrdersService appGrabOrdersService;

    @ApiOperation(value = "随机生成抢单商品")
    @RequestMapping(value = "/random", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult randomOrders(@RequestBody AppRandomOrderPram appRandomOrderPram) throws Exception {
        AppGoods appGoods = appGrabOrdersService.randomOrders(appRandomOrderPram);
        return CommonResult.success(appGoods);

    }

}
