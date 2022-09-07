package my.fast.admin.cg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/7 10:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppWithdrawalParam {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "操作类型【1.待审核 2.已驳回 3.已打款 】")
    private int status;
}
