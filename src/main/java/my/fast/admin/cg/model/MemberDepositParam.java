package my.fast.admin.cg.model;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class MemberDepositParam implements Serializable {
    
    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "操作金额")
    private BigDecimal operaMount;
    
    @ApiModelProperty(value = "备注")
    private String remank;
    
    @ApiModelProperty(value = "渠道id")
    private Long channelId;


    public Long getMemberId() {
		return memberId;
	}



	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}



	public BigDecimal getOperaMount() {
		return operaMount;
	}



	public void setOperaMount(BigDecimal operaMount) {
		this.operaMount = operaMount;
	}



	public String getRemank() {
		return remank;
	}



	public void setRemank(String remank) {
		this.remank = remank;
	}



	public Long getChannelId() {
		return channelId;
	}



	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}



	private static final long serialVersionUID = 1L;

    
}