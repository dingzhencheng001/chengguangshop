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
 * @since 2022/7/27 14:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountChangeParam {

    @ApiModelProperty(value = "开始时间")
    private Date selectBeginTime;

    @ApiModelProperty(value = "结束时间")
    private Date selectEndTime;

    @ApiModelProperty(value = "操作类型【1.充值 2.减少 3.冻结 4.提取】")
    private Integer operaType;

}
