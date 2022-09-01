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
 * @since 2022/9/1 11:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberIncomeVo {

    @ApiModelProperty(value = "总佣金")
    private BigDecimal totalCommission;

    @ApiModelProperty(value = "当日佣金")
    private BigDecimal todayCommission;

}
