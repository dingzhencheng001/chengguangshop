package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppGoodsSort implements Serializable {
    private Long id;

    @ApiModelProperty(value = "佣金比例")
    private Float commissionRate;

    @ApiModelProperty(value = "分类名称")
    private String sortName;

    @ApiModelProperty(value = "简介")
    private String explainSimple;

    @ApiModelProperty(value = "添加时间")
    private Date goodsAddTime;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "绑定会员等级")
    private Integer bindLevel;

    @ApiModelProperty(value = "最低金额")
    private BigDecimal minAmount;

    @ApiModelProperty(value = "分类logo")
    private String sortLogo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getExplainSimple() {
        return explainSimple;
    }

    public void setExplainSimple(String explainSimple) {
        this.explainSimple = explainSimple;
    }

    public Date getGoodsAddTime() {
        return goodsAddTime;
    }

    public void setGoodsAddTime(Date goodsAddTime) {
        this.goodsAddTime = goodsAddTime;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getBindLevel() {
        return bindLevel;
    }

    public void setBindLevel(Integer bindLevel) {
        this.bindLevel = bindLevel;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public String getSortLogo() {
        return sortLogo;
    }

    public void setSortLogo(String sortLogo) {
        this.sortLogo = sortLogo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append(", sortName=").append(sortName);
        sb.append(", explainSimple=").append(explainSimple);
        sb.append(", goodsAddTime=").append(goodsAddTime);
        sb.append(", channelId=").append(channelId);
        sb.append(", bindLevel=").append(bindLevel);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", sortLogo=").append(sortLogo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}