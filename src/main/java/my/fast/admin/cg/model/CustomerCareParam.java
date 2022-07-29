package my.fast.admin.cg.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class CustomerCareParam implements Serializable {
	@ApiModelProperty(value = "页码")
    private Integer pageNum;
	
    @ApiModelProperty(value = "分页数")
    private Integer pageSize;
    
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

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
   
}