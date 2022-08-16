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
import my.fast.admin.cg.entity.AppMemberDeposit;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.ListDepositParam;
import my.fast.admin.cg.model.MemberDepositParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.MemberDepositService;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 11:49
 */
@Controller
@Api(tags = "MemberDepositController", description = "会员充值管理")
@RequestMapping("/action/deposit")
public class MemberDepositController {


    @Autowired
    private MemberDepositService depositService;

    @Autowired
    private AppChannelService appChannelService;

    @RequestMapping("/lists")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("transaction/depositList");
        return mav;
    }

    @ApiOperation(value = "根据条件获取分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberDeposit>> getList(@RequestBody ListDepositParam deposit,
        HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        deposit.setChannelId(channelId);
        List<AppMemberDeposit> depositList = depositService.listDeposit(deposit, deposit.getPageNum(), deposit.getPageSize());
        return CommonResult.success(CommonPage.restPage(depositList));
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = depositService.deleteDepositById(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

   
    @ApiOperation(value = "充值")
    @RequestMapping(value = "/deposit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult deposit(@RequestBody MemberDepositParam deposit,HttpServletRequest request) {
    	if (deposit.getMemberId() == null ) {
            return CommonResult.failed("815");
        }
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        deposit.setChannelId(channelId);
        CommonResult commonResult;
        int count = depositService.createDeposit(deposit);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}
