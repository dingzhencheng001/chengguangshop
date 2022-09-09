package my.fast.admin.cg.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/9 14:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberWithdrawalInfoVo {


    @ApiModelProperty(value = "提现总金额")
    private BigDecimal totalWithdrawal;

    @ApiModelProperty(value = "提现次数")
    private Integer totalWithdrawalTimes;

    @ApiModelProperty(value = "当日提现金额")
    private BigDecimal dayWithdrawal;

    @ApiModelProperty(value = "当日提现次数")
    private Integer dayWithdrawalTimes;

}
