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
 * @since 2022/8/23 17:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppTeamAllVo {

    @ApiModelProperty(value = "账户总额")
    private BigDecimal allBalance;

    @ApiModelProperty(value = "团队总人数")
    private int allSize;

    @ApiModelProperty(value = "总佣金")
    private BigDecimal allCommission;

    @ApiModelProperty(value = "下级会员信息列表")
    private List<AppTeamReportInfo> subordinate;


}
