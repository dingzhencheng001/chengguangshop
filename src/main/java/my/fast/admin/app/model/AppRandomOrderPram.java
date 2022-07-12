package my.fast.admin.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 抢单参数
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/12 15:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppRandomOrderPram {

    @ApiModelProperty(value = "会员ID")
    private Long memberId;
}
