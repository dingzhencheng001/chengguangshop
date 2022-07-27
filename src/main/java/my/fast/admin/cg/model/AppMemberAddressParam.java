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
 * @since 2022/7/12 11:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppMemberAddressParam {


    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "收货姓名")
    private String name;

    @ApiModelProperty(value = "收货手机")
    private String tel;

    @ApiModelProperty(value = "地区")
    private String area;

    @ApiModelProperty(value = "地址-详情")
    private String address;

    @ApiModelProperty(value = "默认地址")
    private String defaultAddr;

    @ApiModelProperty(value = "完成交易时间")
    private Date finishTime;
}
