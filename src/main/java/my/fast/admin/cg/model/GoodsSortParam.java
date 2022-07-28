package my.fast.admin.cg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/28 14:39
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsSortParam {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "分页数")
    private Integer pageSize;


}
