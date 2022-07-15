package my.fast.admin.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AppMemberParam implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "账号冻结金额")
    private BigDecimal freezeBalance;

    @ApiModelProperty(value = "日充值金额")
    private BigDecimal rechargeNum;

    @ApiModelProperty(value = "日提现金额")
    private BigDecimal depositNum;

    @ApiModelProperty(value = "扣除金额")
    private BigDecimal deductionNum;

    @ApiModelProperty(value = "JSON下单规则")
    private String matching;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "上级关联ID(如果该用户不是可登录后台的真代理,该项必填)")
    private Long parentUserId;

    @ApiModelProperty(value = "上级伪代理用户名称或上级真实代理用户昵称")
    private String parentUserName;

    @ApiModelProperty(value = "代理账号标识（0代理账号[新增时候维护tb_app_user和sys_user] 1普通管理员账号[新增时候维护sys_user]）【0:真实代理 1:伪代理,不可登录后台】")
    private Integer isAgent;

    @ApiModelProperty(value = "字典项 代理等级")
    private Integer agentLevel;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "删除标志（1代表存在 2代表删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginDate;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "机构id")
    private Long companyId;

    @ApiModelProperty(value = "邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "会员注册时间")
    private Date registrationTime;

    @ApiModelProperty(value = "会员状态:1.真人2.假人")
    private Integer memberStatus;

    @ApiModelProperty(value = "注册ip")
    private String registerIp;

    @ApiModelProperty(value = "注册国家")
    private String registerCountry;

    @ApiModelProperty(value = "会员个人总佣金")
    private BigDecimal totalCommission;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public BigDecimal getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(BigDecimal rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public BigDecimal getDepositNum() {
        return depositNum;
    }

    public void setDepositNum(BigDecimal depositNum) {
        this.depositNum = depositNum;
    }

    public BigDecimal getDeductionNum() {
        return deductionNum;
    }

    public void setDeductionNum(BigDecimal deductionNum) {
        this.deductionNum = deductionNum;
    }

    public String getMatching() {
        return matching;
    }

    public void setMatching(String matching) {
        this.matching = matching;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getParentUserName() {
        return parentUserName;
    }

    public void setParentUserName(String parentUserName) {
        this.parentUserName = parentUserName;
    }

    public Integer getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Integer isAgent) {
        this.isAgent = isAgent;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterCountry() {
        return registerCountry;
    }

    public void setRegisterCountry(String registerCountry) {
        this.registerCountry = registerCountry;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", balance=").append(balance);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", rechargeNum=").append(rechargeNum);
        sb.append(", depositNum=").append(depositNum);
        sb.append(", deductionNum=").append(deductionNum);
        sb.append(", matching=").append(matching);
        sb.append(", password=").append(password);
        sb.append(", parentUserId=").append(parentUserId);
        sb.append(", parentUserName=").append(parentUserName);
        sb.append(", isAgent=").append(isAgent);
        sb.append(", agentLevel=").append(agentLevel);
        sb.append(", status=").append(status);
        sb.append(", email=").append(email);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", companyId=").append(companyId);
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append(", memberStatus=").append(memberStatus);
        sb.append(", registerIp=").append(registerIp);
        sb.append(", registerCountry=").append(registerCountry);
        sb.append(", totalCommission=").append(totalCommission);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}