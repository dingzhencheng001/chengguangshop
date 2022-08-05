package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppAssignGoods implements Serializable {
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

    @ApiModelProperty(value = "任务组")
    private Integer taskGroup;

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

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getGoodsSortId() {
        return goodsSortId;
    }

    public void setGoodsSortId(Long goodsSortId) {
        this.goodsSortId = goodsSortId;
    }

    public Integer getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(Integer taskGroup) {
        this.taskGroup = taskGroup;
    }

    public Integer getHinder() {
        return hinder;
    }

    public void setHinder(Integer hinder) {
        this.hinder = hinder;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getIsConsumed() {
        return isConsumed;
    }

    public void setIsConsumed(Integer isConsumed) {
        this.isConsumed = isConsumed;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getWhichGroup() {
        return whichGroup;
    }

    public void setWhichGroup(Integer whichGroup) {
        this.whichGroup = whichGroup;
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
        sb.append(", goodsPic=").append(goodsPic);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsAddTime=").append(goodsAddTime);
        sb.append(", status=").append(status);
        sb.append(", channelId=").append(channelId);
        sb.append(", memberId=").append(memberId);
        sb.append(", goodsSortId=").append(goodsSortId);
        sb.append(", taskGroup=").append(taskGroup);
        sb.append(", hinder=").append(hinder);
        sb.append(", orderQuantity=").append(orderQuantity);
        sb.append(", isConsumed=").append(isConsumed);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", whichGroup=").append(whichGroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}