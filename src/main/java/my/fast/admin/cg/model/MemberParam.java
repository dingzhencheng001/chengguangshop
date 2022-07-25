package my.fast.admin.cg.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class MemberParam implements Serializable {

    @ApiModelProperty(value = "会员Id")
    private Long memberId;

    @ApiModelProperty(value = "会员等级")
    private Long memberLevel;

	public Long getMemberId() {
		return memberId;
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