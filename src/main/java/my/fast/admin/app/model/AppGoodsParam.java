package my.fast.admin.app.model;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌请求参数
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/10 17:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppGoodsParam {

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品描述")
    private String goodsInfo;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品添加时间")
    private Date goodsAddTime;

    @ApiModelProperty(value = "上架状态 0不上架 1上架")
    private Integer status;

    @ApiModelProperty(value = "商品展示图片")
    private String goodsPic;

}
