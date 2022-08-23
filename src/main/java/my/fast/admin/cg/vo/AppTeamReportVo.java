package my.fast.admin.cg.vo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import my.fast.admin.cg.entity.AppMember;
import my.fast.admin.cg.model.AppTeamReportInfo;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/19 10:58
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AppTeamReportVo {


    @ApiModelProperty(value = "总数据")
    private AppTeamAllVo appTeamAllVo;

    @ApiModelProperty(value = "等级数据列表")
    private List<AppTeamVo> appTeamVo;


}
