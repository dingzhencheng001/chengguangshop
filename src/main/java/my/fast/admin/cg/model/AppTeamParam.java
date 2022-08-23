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
 * @since 2022/8/23 10:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppTeamParam {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "开始时间")
    private Date selectBeginTime;

    @ApiModelProperty(value = "结束时间")
    private Date selectEndTime;

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

}
