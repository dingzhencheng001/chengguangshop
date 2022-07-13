package my.fast.admin.app.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/13 15:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberBalancePram {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "佣金")
    private BigDecimal grabCommission;
}
