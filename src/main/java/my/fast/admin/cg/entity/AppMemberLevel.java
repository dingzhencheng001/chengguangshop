package my.fast.admin.cg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppMemberLevel implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员名称")
    private String membersName;

    @ApiModelProperty(value = "接单限制")
    private Integer orderNum;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

    @ApiModelProperty(value = "佣金比例")
    private BigDecimal commission;

    @ApiModelProperty(value = "会员等级")
    private Integer membersLevel;

    @ApiModelProperty(value = "提现次数")
    private Integer withdrawalTimes;

    @ApiModelProperty(value = "提现最小金额")
    private Integer withdrawalMin;

    @ApiModelProperty(value = "提现最大金额")
    private Integer withdrawalMax;

    @ApiModelProperty(value = "最小余额")
    private Integer numMin;

    @ApiModelProperty(value = "提现最少完成订单数")
    private Integer withdrawalNimOrder;

    @ApiModelProperty(value = "自动升级vip需要邀请的人数")
    private Integer autoVipXuNum;

    @ApiModelProperty(value = "提现手续费")
    private BigDecimal serviceCharge;

    @ApiModelProperty(value = "图标")
    private String pic;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getMembersLevel() {
        return membersLevel;
    }

    public void setMembersLevel(Integer membersLevel) {
        this.membersLevel = membersLevel;
    }

    public Integer getWithdrawalTimes() {
        return withdrawalTimes;
    }

    public void setWithdrawalTimes(Integer withdrawalTimes) {
        this.withdrawalTimes = withdrawalTimes;
    }

    public Integer getWithdrawalMin() {
        return withdrawalMin;
    }

    public void setWithdrawalMin(Integer withdrawalMin) {
        this.withdrawalMin = withdrawalMin;
    }

    public Integer getWithdrawalMax() {
        return withdrawalMax;
    }

    public void setWithdrawalMax(Integer withdrawalMax) {
        this.withdrawalMax = withdrawalMax;
    }

    public Integer getNumMin() {
        return numMin;
    }

    public void setNumMin(Integer numMin) {
        this.numMin = numMin;
    }

    public Integer getWithdrawalNimOrder() {
        return withdrawalNimOrder;
    }

    public void setWithdrawalNimOrder(Integer withdrawalNimOrder) {
        this.withdrawalNimOrder = withdrawalNimOrder;
    }

    public Integer getAutoVipXuNum() {
        return autoVipXuNum;
    }

    public void setAutoVipXuNum(Integer autoVipXuNum) {
        this.autoVipXuNum = autoVipXuNum;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", membersName=").append(membersName);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", commission=").append(commission);
        sb.append(", membersLevel=").append(membersLevel);
        sb.append(", withdrawalTimes=").append(withdrawalTimes);
        sb.append(", withdrawalMin=").append(withdrawalMin);
        sb.append(", withdrawalMax=").append(withdrawalMax);
        sb.append(", numMin=").append(numMin);
        sb.append(", withdrawalNimOrder=").append(withdrawalNimOrder);
        sb.append(", autoVipXuNum=").append(autoVipXuNum);
        sb.append(", serviceCharge=").append(serviceCharge);
        sb.append(", pic=").append(pic);
        sb.append(", channelId=").append(channelId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}