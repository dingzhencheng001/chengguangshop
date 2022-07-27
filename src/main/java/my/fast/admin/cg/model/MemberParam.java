package my.fast.admin.cg.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class MemberParam implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "页码")
    private Integer pageNum;
	
    @ApiModelProperty(value = "分页数")
    private Integer pageSize;
	
	@ApiModelProperty(value = "会员Id")
    private Long memberId;

    @ApiModelProperty(value = "会员等级")
    private Long memberLevel;

	@ApiModelProperty(value = "用户名")
	private String userAccount;
	
	@ApiModelProperty(value = "手机号")
	private String phoneNumber;
	
	@ApiModelProperty(value = "开始时间")
	private Date selectBeginTime;

	@ApiModelProperty(value = "结束时间")
	private Date selectEndTime;
	
	@ApiModelProperty(value = "渠道id")
    private Long channelId;
	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getSelectBeginTime() {
		return selectBeginTime;
	}

	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setSelectBeginTime(Date selectBeginTime) {
		this.selectBeginTime = selectBeginTime;
	}

	public Date getSelectEndTime() {
		return selectEndTime;
	}

	public void setSelectEndTime(Date selectEndTime) {
		this.selectEndTime = selectEndTime;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Long memberLevel) {
		this.memberLevel = memberLevel;
	}


   
}