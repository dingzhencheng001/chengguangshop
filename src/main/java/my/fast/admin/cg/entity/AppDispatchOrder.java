package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppDispatchOrder implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "抢单id")
    private Long conveyId;

    @ApiModelProperty(value = "派单商品id")
    private Long distributionGoodsId;

    @ApiModelProperty(value = "是否卡单1.卡单2.不卡单")
    private Integer hinder;

    @ApiModelProperty(value = "第几单")
    private Integer orderQuantity;

    @ApiModelProperty(value = "最小价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "最大价")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    @ApiModelProperty(value = "订单状态0.未完成1.完成")
    private Integer orderStatus;

    @ApiModelProperty(value = "商品id")
    private Long traditionGoodsId;

    @ApiModelProperty(value = "流水号")
    private String serialNumber;

    @ApiModelProperty(value = "订单完成时间")
    private Date finishTime;

    @ApiModelProperty(value = "第几组")
    private Integer whichGroup;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getConveyId() {
        return conveyId;
    }

    public void setConveyId(Long conveyId) {
        this.conveyId = conveyId;
    }

    public Long getDistributionGoodsId() {
        return distributionGoodsId;
    }

    public void setDistributionGoodsId(Long distributionGoodsId) {
        this.distributionGoodsId = distributionGoodsId;
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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getTraditionGoodsId() {
        return traditionGoodsId;
    }

    public void setTraditionGoodsId(Long traditionGoodsId) {
        this.traditionGoodsId = traditionGoodsId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
        sb.append(", memberId=").append(memberId);
        sb.append(", channelId=").append(channelId);
        sb.append(", conveyId=").append(conveyId);
        sb.append(", distributionGoodsId=").append(distributionGoodsId);
        sb.append(", hinder=").append(hinder);
        sb.append(", orderQuantity=").append(orderQuantity);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", traditionGoodsId=").append(traditionGoodsId);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", whichGroup=").append(whichGroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}