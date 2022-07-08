package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppMemberAccountChange implements Serializable {
    private Long id;

    @ApiModelProperty(value = "账户ID")
    private Long accountId;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "充值类型 USDT")
    private Integer currencyType;

    @ApiModelProperty(value = "操作类型【1.充值 2.减少 3.冻结】")
    private Integer operaType;

    @ApiModelProperty(value = "操作前余额")
    private BigDecimal preOperaMount;

    @ApiModelProperty(value = "操作金额")
    private BigDecimal operaMount;

    @ApiModelProperty(value = "当前总计余额")
    private BigDecimal totalMount;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Integer getOperaType() {
        return operaType;
    }

    public void setOperaType(Integer operaType) {
        this.operaType = operaType;
    }

    public BigDecimal getPreOperaMount() {
        return preOperaMount;
    }

    public void setPreOperaMount(BigDecimal preOperaMount) {
        this.preOperaMount = preOperaMount;
    }

    public BigDecimal getOperaMount() {
        return operaMount;
    }

    public void setOperaMount(BigDecimal operaMount) {
        this.operaMount = operaMount;
    }

    public BigDecimal getTotalMount() {
        return totalMount;
    }

    public void setTotalMount(BigDecimal totalMount) {
        this.totalMount = totalMount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", memberId=").append(memberId);
        sb.append(", currencyType=").append(currencyType);
        sb.append(", operaType=").append(operaType);
        sb.append(", preOperaMount=").append(preOperaMount);
        sb.append(", operaMount=").append(operaMount);
        sb.append(", totalMount=").append(totalMount);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}