package my.fast.admin.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/20 11:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FileInfo {

    @ApiModelProperty(value = "文件id")
    private String id;

    @ApiModelProperty(value = "文件路径")
    private String path;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件名字")
    private String name;


}
