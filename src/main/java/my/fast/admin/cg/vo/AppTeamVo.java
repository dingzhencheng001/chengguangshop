package my.fast.admin.cg.vo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import my.fast.admin.cg.model.AppTeamReportInfo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/23 17:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppTeamVo {

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "账户总额")
    private BigDecimal teamBalance;

    @ApiModelProperty(value = "团队总人数")
    private int teamSize;

    @ApiModelProperty(value = "团队佣金")
    private BigDecimal teamCommission;

    @ApiModelProperty(value = "下级会员信息列表")
    private List<AppTeamReportInfo> subordinate;
}
