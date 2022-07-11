package my.fast.admin.app.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AppMemberBank implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行编号")
    private String bankNumber;

    @ApiModelProperty(value = "银行卡号")
    private String cardNum;

    @ApiModelProperty(value = "开户名")
    private String accountName;

    @ApiModelProperty(value = "开户行地址或者IFSC")
    private String site;

    @ApiModelProperty(value = "银行所在国家")
    private String bankCountry;

    @ApiModelProperty(value = "银行所在国家")
    private String tel;

    @ApiModelProperty(value = "状态，1启用，0禁用")
    private Integer status;

    @ApiModelProperty(value = "开户行地址或者IFSC")
    private String email;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankNumber=").append(bankNumber);
        sb.append(", cardNum=").append(cardNum);
        sb.append(", accountName=").append(accountName);
        sb.append(", site=").append(site);
        sb.append(", bankCountry=").append(bankCountry);
        sb.append(", tel=").append(tel);
        sb.append(", status=").append(status);
        sb.append(", email=").append(email);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}