package my.fast.admin.cg.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import my.fast.admin.cg.entity.SysChannel;
import my.fast.admin.cg.entity.SysNotice;
import my.fast.admin.cg.service.AppChannelService;
import my.fast.admin.cg.service.NoticeService;

/**
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/18 16:02
 */
@Controller
@Api(tags = "NoticeController", description = "消息通知管理")
@RequestMapping("/action/notice")
public class NoticeController {

	@RequestMapping("/notice")
			public Object notice() {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("notice/notice");
					return mav;
			}

	@RequestMapping("/swiper")
	public Object swiper() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("addSwiper/addSwiper");
			return mav;
	}


    @Autowired
    private NoticeService NoticeService;

    @Autowired
    private AppChannelService appChannelService;


    @ApiOperation(value = "获取消息通知列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysNotice>> getNoticeList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize, HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        List<SysNotice> noticeList = NoticeService.getNoticeList(pageNum, pageSize,channelId);
        return CommonResult.success(CommonPage.restPage(noticeList));
    }

    @ApiOperation(value = "删除消息通知")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = NoticeService.deleteNotice(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "更新消息通知")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody SysNotice sysNotice) {
        CommonResult commonResult;
        int count = NoticeService.updateNotice(id, sysNotice);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "新增新消息通知")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CommonResult create(@RequestBody SysNotice sysNotice,HttpServletRequest request) {
        //根据域名获取渠道号
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        SysChannel sysChannel = appChannelService.getChannelInfoByAppDns(tempContextUrl);
        if (sysChannel == null || sysChannel.getChannelId()==null ) {
            return CommonResult.failed("801");
        }
        Long channelId = sysChannel.getChannelId();
        CommonResult commonResult;
        sysNotice.setStatus("0");
        if(sysNotice.getNoticeClasses()==null){
        	sysNotice.setNoticeClasses(3);//其他通知
        }
        if(sysNotice.getNoticeType()==null){
        	sysNotice.setNoticeType("1");//通知
        }
        int count = NoticeService.createNotice(sysNotice,channelId);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


}

