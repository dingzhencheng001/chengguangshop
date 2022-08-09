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
 * @since 2022/8/9 18:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QiangNumParam {

    @ApiModelProperty(value = "查询时间")
    private String selectTime;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

}
