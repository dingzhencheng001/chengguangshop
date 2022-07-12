package my.fast.admin.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppGoods implements Serializable {
    private Long id;

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品描述")
    private String goodsInfo;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品展示图片")
    private String goodsPic;

    @ApiModelProperty(value = "商品添加时间")
    private Date goodsAddTime;

    @ApiModelProperty(value = "上架状态 0不上架 1上架")
    private Integer status;

    @ApiModelProperty(value = "商品分类id")
    private Long goodsSortId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Date getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(Date goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGoodsSortId() {
        return goodsSortId;
    }

    public void setGoodsSortId(Long goodsSortId) {
        this.goodsSortId = goodsSortId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopName=").append(shopName);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsInfo=").append(goodsInfo);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsPic=").append(goodsPic);
        sb.append(", goodsAddTime=").append(goodsAddTime);
        sb.append(", status=").append(status);
        sb.append(", goodsSortId=").append(goodsSortId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}