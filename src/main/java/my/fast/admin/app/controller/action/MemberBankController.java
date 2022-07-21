package my.fast.admin.app.controller.action;

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
import my.fast.admin.app.common.constant.CommonPage;
import my.fast.admin.app.common.constant.CommonResult;
import my.fast.admin.app.entity.AppMemberBank;
import my.fast.admin.app.service.AppMemberBankService;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/11 15:09
 */
@Controller
@Api(tags = "MemberBankController", description = "会员银行卡信息管理")
@RequestMapping("/bankaction")
public class MemberBankController {
	
    @Autowired
    private AppMemberBankService appMemberBankService;

    @ApiOperation("获取会员银行卡信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listAll() {
        List<AppMemberBank> appMemberBanks = appMemberBankService.listAll();
        return CommonResult.success(appMemberBanks);
    }

    @ApiOperation(value = "获取会员银行卡信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AppMemberBank>> getList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        List<AppMemberBank> appMemberBankList = appMemberBankService.listBanks( pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(appMemberBankList));
    }

    @ApiOperation(value = "删除会员银行卡信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = appMemberBankService.deleteBanks(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "添加/更新会员银行卡信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult save(@RequestBody AppMemberBank appMemberBank,HttpServletRequest request) {
    	CommonResult commonResult;
    	AppMemberBank  tempBank = appMemberBankService.getMemberBank(appMemberBank.getMemberId());
        if(tempBank == null){//新增
        	int count = appMemberBankService.createBanks(appMemberBank);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }else{//更新
        	if(appMemberBank.getId()==null){
        		appMemberBank.setId(tempBank.getId());
        	}
        	int count = appMemberBankService.updateBanks(appMemberBank);
            if (count == 1) {
                commonResult = CommonResult.success(count);
            } else {
                commonResult = CommonResult.failed();
            }
        }
        return commonResult;
    }

    @ApiOperation(value = "查询会员银行卡信息")
    @RequestMapping(value = "/getmemberbank/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberBank(@PathVariable("id") Long id,HttpServletRequest request) {
    	
    	AppMemberBank appMemberBank = appMemberBankService.getMemberBank(id);
    	return CommonResult.success(appMemberBank);
    }
    
    
    

}
