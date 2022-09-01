package my.fast.admin.cg.model;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberDepositParam implements Serializable {
    
    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "操作金额")
    private BigDecimal operaMount;
    
    @ApiModelProperty(value = "备注")
    private String remark;
    
    @ApiModelProperty(value = "渠道id")
    private Long channelId;

}