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
 * @since 2022/7/26 17:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberWithdrawalPram {

    @ApiModelProperty(value = "交易订单号")
    private String orderNo;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "开始时间")
    private Date selectBeginTime;

    @ApiModelProperty(value = "发起时间")
    private Date selectEndTime;


}
