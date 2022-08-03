package my.fast.admin.cg.vo;

import io.swagger.annotations.ApiModelProperty;
import my.fast.admin.cg.entity.AppMemberLevel;
import my.fast.admin.cg.entity.SysAgentList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppMemberVo implements Serializable {
    private Long id; 

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNum;

    @ApiModelProperty(value = "实名认证状态，0未审核，1审核通过，2审核不通过")
    private Integer idStatus;

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

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "交易状态:交易冻结1停止交易2等待交易3交易中")
    private Integer dealStatus;

    @ApiModelProperty(value = "违规次数")
    private Integer dealError;

    @ApiModelProperty(value = "奖励交易次数")
    private Integer dealRewardCount;

    @ApiModelProperty(value = "当日交易次数")
    private Integer dealCount;

    @ApiModelProperty(value = "最后交易日期(年月日)")
    private Date dealTime;

    @ApiModelProperty(value = "激活状态，0未激活(首次充值发放推广奖励)，1已激活")
    private Integer active;

    @ApiModelProperty(value = "最小匹配")
    private Integer matchMin;

    @ApiModelProperty(value = "最大匹配")
    private Integer matchMax;

    @ApiModelProperty(value = "会员注册时间")
    private Date registrationTime;

    @ApiModelProperty(value = "会员状态:1.真人2.假人")
    private Integer memberStatus;

    @ApiModelProperty(value = "注册ip")
    private String registerIp;

    @ApiModelProperty(value = "注册国家")
    private String registerCountry;

    @ApiModelProperty(value = "身份证正面图")
    private String topPic;

    @ApiModelProperty(value = "身份证正面图")
    private String botPic;
    
    @ApiModelProperty(value = "今日佣金金额")
    private BigDecimal todaySum;
    
    @ApiModelProperty(value = "总佣金金额")
    private BigDecimal totalCommission;
    
    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    @ApiModelProperty(value = "会员等级")
    private Integer membersLevel;

    @ApiModelProperty(value = "设定金额")
    private BigDecimal limitAmount;
    
    @ApiModelProperty(value = "提现状态(0:正常 1 禁止提现)")
    private Integer drawalStatus;
    
    public BigDecimal getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
	}


	public Integer getDrawalStatus() {
		return drawalStatus;
	}

	public void setDrawalStatus(Integer drawalStatus) {
		this.drawalStatus = drawalStatus;
	}

	public Integer getMembersLevel() {
        return membersLevel;
    }

    public void setMembersLevel(Integer membersLevel) {
        this.membersLevel = membersLevel;
    }

    //会员等级列表
    private List<AppMemberLevel> levelList;
    
    //随机代理佣金展示
    private List<SysAgentList> agentList;
    
    private static final long serialVersionUID = 1L;

    
    public List<SysAgentList> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<SysAgentList> agentList) {
		this.agentList = agentList;
	}

	public List<AppMemberLevel> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<AppMemberLevel> levelList) {
		this.levelList = levelList;
	}

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getDealError() {
        return dealError;
    }

    public void setDealError(Integer dealError) {
        this.dealError = dealError;
    }

    public Integer getDealRewardCount() {
        return dealRewardCount;
    }

    public void setDealRewardCount(Integer dealRewardCount) {
        this.dealRewardCount = dealRewardCount;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getMatchMin() {
        return matchMin;
    }

    public void setMatchMin(Integer matchMin) {
        this.matchMin = matchMin;
    }

    public Integer getMatchMax() {
        return matchMax;
    }

    public void setMatchMax(Integer matchMax) {
        this.matchMax = matchMax;
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

    public String getTopPic() {
        return topPic;
    }

    public void setTopPic(String topPic) {
        this.topPic = topPic;
    }

    public String getBotPic() {
        return botPic;
    }

    public void setBotPic(String botPic) {
        this.botPic = botPic;
    }
    
    public BigDecimal getTodaySum() {
		return todaySum;
	}

	public void setTodaySum(BigDecimal todaySum) {
		this.todaySum = todaySum;
	}

	public BigDecimal getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(BigDecimal totalCommission) {
		this.totalCommission = totalCommission;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "AppMemberVo [id=" + id + ", memberLevelId=" + memberLevelId + ", userAccount=" + userAccount
				+ ", nickName=" + nickName + ", realName=" + realName + ", idCardNum=" + idCardNum + ", idStatus="
				+ idStatus + ", balance=" + balance + ", freezeBalance=" + freezeBalance + ", rechargeNum="
				+ rechargeNum + ", depositNum=" + depositNum + ", deductionNum=" + deductionNum + ", matching="
				+ matching + ", password=" + password + ", parentUserId=" + parentUserId + ", parentUserName="
				+ parentUserName + ", isAgent=" + isAgent + ", agentLevel=" + agentLevel + ", status=" + status
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", delFlag=" + delFlag + ", loginIp=" + loginIp
				+ ", loginDate=" + loginDate + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + ", remark=" + remark + ", inviteCode=" + inviteCode
				+ ", dealStatus=" + dealStatus + ", dealError=" + dealError + ", dealRewardCount=" + dealRewardCount
				+ ", dealCount=" + dealCount + ", dealTime=" + dealTime + ", active=" + active + ", matchMin="
				+ matchMin + ", matchMax=" + matchMax + ", registrationTime=" + registrationTime + ", memberStatus="
				+ memberStatus + ", registerIp=" + registerIp + ", registerCountry=" + registerCountry + ", topPic="
				+ topPic + ", botPic=" + botPic + ", todaySum=" + todaySum + ", totalCommission=" + totalCommission
				+ ", channelId=" + channelId + ", membersLevel=" + membersLevel + ", limitAmount=" + limitAmount
				+ ", drawalStatus=" + drawalStatus + ", levelList=" + levelList + ", agentList=" + agentList + "]";
	}

	
	
	
}