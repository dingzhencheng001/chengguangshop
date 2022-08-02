package my.fast.admin.cg.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/28 11:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppConveyParam {

    @ApiModelProperty(value = "开始时间")
    private Date selectBeginTime;

    @ApiModelProperty(value = "结束时间")
    private Date selectEndTime;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "分页数")
    private Integer pageSize;

    @ApiModelProperty(value = "用户名")
    private String userAccount;

    @ApiModelProperty(value = "交易订单号")
    private String lno;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "交易状态")
    private String status;

    @ApiModelProperty(value = "会员手机号")
    private String phoneNumber;

    
}
