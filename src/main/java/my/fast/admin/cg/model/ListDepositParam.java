package my.fast.admin.cg.model;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
public class ListDepositParam implements Serializable {
    
	@ApiModelProperty(value = "页码")
    private Integer pageNum;
	
    @ApiModelProperty(value = "分页数")
    private Integer pageSize;
    
	@ApiModelProperty(value = "订单号")
	private String orderNo;
	
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


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public void setSelectBeginTime(Date selectBeginTime) {
		this.selectBeginTime = selectBeginTime;
	}

	public Date getSelectEndTime() {
		return selectEndTime;
	}

	public void setSelectEndTime(Date selectEndTime) {
		this.selectEndTime = selectEndTime;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
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

	private static final long serialVersionUID = 1L;

    
}