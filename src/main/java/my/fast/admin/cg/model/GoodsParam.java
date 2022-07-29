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
 * @since 2022/7/29 11:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsParam {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "分页数")
    private Integer pageSize;

    @ApiModelProperty(value = "最小价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "最大价")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品分类id")
    private Long goodsSortId;

}
