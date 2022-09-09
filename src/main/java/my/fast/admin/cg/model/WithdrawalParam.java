package my.fast.admin.cg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/9 15:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WithdrawalParam {

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

}
