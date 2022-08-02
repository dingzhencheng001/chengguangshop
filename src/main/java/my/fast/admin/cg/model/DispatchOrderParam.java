package my.fast.admin.cg.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/30 14:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DispatchOrderParam {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "是否卡单1.卡单2.不卡单")
    private Integer hinder;

    @ApiModelProperty(value = "第几单")
    private Integer orderQuantity;

    @ApiModelProperty(value = "最小价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "最大价")
    private BigDecimal maxPrice;
}