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
import my.fast.admin.cg.entity.AppMemberBank;
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.MemberBankService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@Controller
@Api(tags = "MemberBankController", description = "会员银行卡信息管理")
@RequestMapping("/action/bank")
public class MemberBankController {
	
    @Autowired
    private MemberBankService MemberBankService;

    @Autowired
    private AppChannelService appChannelService;

    @ApiOperation(value = "获取会员银行卡信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberBank>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, HttpServletRequest request) {
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
        List<AppMemberBank> appMemberBankList = MemberBankService.listBanks(pageNum, pageSize, channelId);
        return CommonResult.success(CommonPage.restPage(appMemberBankList));
    }

    @ApiOperation(value = "删除会员银行卡信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id, HttpServletRequest request) {
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
        int count = MemberBankService.deleteBanks(id, channelId);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
}

    @ApiOperation(value = "查询会员银行卡信息")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberBank(@PathVariable("id") Long memberId, HttpServletRequest request) {
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
        AppMemberBank appMemberBank = MemberBankService.getMemberBank(memberId, channelId);
        return CommonResult.success(appMemberBank);
    }

    @ApiOperation(value = "添加/更新会员银行卡信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult save(@RequestBody AppMemberBank appMemberBank,HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("渠道查询错误，渠道ID不存在");
        }
        Long channelId = sysChannel.getChannelId();
        CommonResult commonResult;
        AppMemberBank  tempBank = MemberBankService.getMemberBank(appMemberBank.getMemberId());
        if(tempBank == null){//新增
            int count = MemberBankService.createBanks(appMemberBank,channelId);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{//更新
            if(appMemberBank.getId()==null){
                appMemberBank.setId(tempBank.getId());
            }
            int count = MemberBankService.updateBanks(appMemberBank,channelId);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }
        return commonResult;
    }
    

}
