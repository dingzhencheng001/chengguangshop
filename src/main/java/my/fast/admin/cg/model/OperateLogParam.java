package my.fast.admin.cg.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class OperateLogParam implements Serializable {
	@ApiModelProperty(value = "页码")
    private Integer pageNum;
	
    @ApiModelProperty(value = "分页数")
    private Integer pageSize;
    
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String operateContent;

    @ApiModelProperty(value = "开始时间")
	private Date selectBeginTime;

	@ApiModelProperty(value = "结束时间")
	private Date selectEndTime;
    
    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    private static final long serialVersionUID = 1L;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
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
   
}