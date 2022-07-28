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
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.model.MemberWithdrawalParam;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.MemberWithdrawalService;
import my.fast.admin.cg.vo.AppMemberWithdrawalVo;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 15:58
 */
@Controller
@Api(tags = "MemberWithdrawalController", description = "会员提现管理")
@RequestMapping("/action/withdrawal")
public class MemberWithdrawalController {

    @Autowired
    private MemberWithdrawalService memberWithdrawalService;

    @Autowired
    private AppChannelService appChannelService;

    @RequestMapping("/lists")
    public Object list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("transaction/withdrawalList");
        return mav;
    }

    @ApiOperation(value = "批量审核提现信息")
    @RequestMapping(value = "/approval/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult approvalBatch(@RequestParam("ids") List<Long> ids,@RequestParam("status") Integer status) {
        int count = memberWithdrawalService.approval(ids,status);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation(value = "驳回提现信息")
    @RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult rejectById(@PathVariable("id") Long id ,@RequestParam String remark) {
        int count = memberWithdrawalService.rejectById(id,remark);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "获取提现分页列表信息")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberWithdrawalVo>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, @RequestBody
        MemberWithdrawalParam withdrawal, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        List<AppMemberWithdrawalVo> appMemberWithdrawalVos = memberWithdrawalService.findPage(pageNum, pageSize,channelId,withdrawal);
        return CommonResult.success(CommonPage.restPage(appMemberWithdrawalVos));
    }

}
