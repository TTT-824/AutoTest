package com.ttt.config;

/*
* swaggerconfig class
* */

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiinfo())
                .pathMapping("/")   //访问路径
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiinfo() {
        return new ApiInfoBuilder().title("本地接口文档")
                .contact(new Contact("TTT","","2248437020@qq.com"))
                .description("ttt的接口文档")
                .version("1.0.0.0")
                .build();
    }
}
