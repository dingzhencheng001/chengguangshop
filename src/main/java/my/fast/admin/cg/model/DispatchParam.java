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
 * @since 2022/8/5 15:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DispatchParam {

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "查询时间")
    private String selectTime;

    @ApiModelProperty(value = "第几组")
    private Integer whichGroup;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "分页数")
    private Integer pageSize;

}
