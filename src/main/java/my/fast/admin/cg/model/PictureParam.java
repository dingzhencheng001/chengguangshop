package my.fast.admin.cg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/8/25 16:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PictureParam {

    @ApiModelProperty(value = "图片类型 1.首页banner")
    private Integer pictureType;

    @ApiModelProperty(value = "展示类型 1.app展示 2.app不展示")
    private Integer showType;

    @ApiModelProperty(value = "渠道id")
    private Long channelId;

}
