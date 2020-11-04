package com.xschen.boot.launch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xschen
 *
 * 通过java config对swagger进行配置
 */

@Configuration
@EnableSwagger2 // 开启SwaggerAPI文档相关的功能
public class SwaggerConfig {

    // 配置接口文档的title(标题)、描述、termsOfServiceUrl（服务协议）、版本等相关信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("boot lanunch 项目 API文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("http://www.zimug.com")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描basePackage包下面的“/rest/”路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.xschen.boot.launch"))
                // paths表示哪一个请求路径下控制器映射方法，作为API接口文档内容范围
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }

}
