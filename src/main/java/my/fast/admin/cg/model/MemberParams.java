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
 * @since 2022/7/27 11:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberParams {


    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "开始时间")
    private Date selectBeginTime;

    @ApiModelProperty(value = "结束时间")
    private Date selectEndTime;

    @ApiModelProperty(value = "会员状态:1.真人2.假人")
    private Integer memberStatus;

}
