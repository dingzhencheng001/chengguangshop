package my.fast.admin.cg.vo;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/30 16:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppGoodsVo {

    private Long id;

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品描述")
    private String goodsInfo;

    @ApiModelProperty(value = "商品展示图片")
    private String goodsPic;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品添加时间")
    private Date goodsAddTime;

    @ApiModelProperty(value = "上架状态 0不上架 1上架")
    private Integer status;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "商品分类id")
    private Long goodsSortId;

    @ApiModelProperty(value = "是否是最后一单1.是2.不是")
    private Integer lastOrder;

    @ApiModelProperty(value = "是否卡单1.卡单2.不卡单")
    private Integer hinder;

    @ApiModelProperty(value = "第几单")
    private Integer orderQuantity;

    @ApiModelProperty(value = "是否被消费0.未消费1.已经消费")
    private Integer isConsumed;

    @ApiModelProperty(value = "流水号")
    private String serialNumber;

    @ApiModelProperty(value = "第几组")
    private Integer whichGroup;

    @ApiModelProperty(value = "派单标识1.派单商品2.传统商品")
    private Integer goodsFlag;

    @ApiModelProperty(value = "佣金")
    private BigDecimal commission;

}
