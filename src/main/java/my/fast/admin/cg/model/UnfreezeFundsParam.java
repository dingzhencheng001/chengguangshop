package my.fast.admin.cg.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/9 15:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UnfreezeFundsParam {

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "流水号")
    private String serialNumber;

    @ApiModelProperty(value = "是否被消费0.未消费1.已经消费")
    private Integer isConsumed;

    @NotEmpty
    @ApiModelProperty(value = "第几组",required = true)
    private Integer whichGroup;

}
