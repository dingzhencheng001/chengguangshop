package my.fast.admin.cg.config;

import org.springframework.context.annotation.Configuration;

import my.fast.admin.cg.common.constant.BaseSwaggerConfig;
import my.fast.admin.cg.common.constant.SwaggerProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by cg on 2020/7/5.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("my.fast.admin.app.controller")
                .title("橙光科技")
                .description("相关接口文档")
                .contactName("cg")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
