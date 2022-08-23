package my.fast.admin.cg.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/23 11:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppTeamReportInfo {

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "会员注册时间")
    private Date registrationTime;

}
