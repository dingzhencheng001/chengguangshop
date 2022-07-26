package my.fast.admin.cg.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import my.fast.admin.cg.entity.AppMember;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/26 17:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberWithdrawalVo {

    @ApiModelProperty(value = "交易订单号")
    private String orderNo;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "真实名字")
    private String realName;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "操作类型【1.充值 2.减少 3.冻结 4.提取】")
    private Integer operaType;

    @ApiModelProperty(value = "操作类型【1.待审核 2.已驳回 3.已打款 】")
    private Integer status;

    @ApiModelProperty(value = "操作金额")
    private BigDecimal operaMount;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "处理时间")
    private Date dealTime;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员银行卡id")
    private Long memberBankId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "0.正常1.删除")
    private Integer isDelete;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行卡号")
    private String bankNum;


}
