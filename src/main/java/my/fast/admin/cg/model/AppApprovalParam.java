package my.fast.admin.cg.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/9/7 10:41
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppApprovalParam {

    @ApiModelProperty(value = "ids")
    List<Long> ids;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "操作类型【1.待审核 2.已驳回 3.已打款 】")
    private int status;
}
