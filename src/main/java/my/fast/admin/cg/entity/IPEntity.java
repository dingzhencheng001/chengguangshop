package my.fast.admin.cg.entity;

import lombok.Data;

/**
 * TODO
 *
 * @author cgkj@cg.cn
 * @version V1.0
 * @since 2022/7/22 16:44
 */
@Data
public class IPEntity {

    //国家
    private String countryName;
    //国家代码
    private String countryCode;

    //省份
    private String provinceName;
    private String provinceCode;

    //城市名称
    private String cityName;

    //邮政编码
    private String postalCode;

    //经度
    private Double longitude;
    //纬度
    private Double latitude;

}
