package my.fast.admin.app.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import my.fast.admin.app.entity.AppMember;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 10:58
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AppCommissionVo {

    @ApiModelProperty(value = "总佣金")
    private BigDecimal totalCommission;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "佣金比例")
    private String commission;

    @ApiModelProperty(value = "代理等级")
    private String agentsLevel;

    @ApiModelProperty(value = "一级代理列表")
    private List<AppMember> primaryAgents;

    @ApiModelProperty(value = "二级代理列表")
    private List<AppMember> secondaryAgents;

    @ApiModelProperty(value = "三级代理列表")
    private List<AppMember> tertiaryAgent;

    @ApiModelProperty(value = "四级代理列表")
    private List<AppMember> fourLevelAgent;

    @ApiModelProperty(value = "五级代理列表")
    private List<AppMember> fiveLevelAgent;

    @ApiModelProperty(value = "一级代理总佣金")
    private BigDecimal primaryAgentsTotalCommission;

    @ApiModelProperty(value = "二级代理总佣金")
    private BigDecimal secondaryAgentsTotalCommission;

    @ApiModelProperty(value = "三级代理总佣金")
    private BigDecimal tertiaryAgentTotalCommission;

    @ApiModelProperty(value = "四级代理总佣金")
    private BigDecimal fourLevelAgentTotalCommission;

    @ApiModelProperty(value = "五级代理总佣金")
    private BigDecimal fiveLevelAgentTotalCommission;
}
