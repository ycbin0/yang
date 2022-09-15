package com.bin.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SwaggerConfig
 * @Description: Swagger配置类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfo("MyWebLearn", "我的学习历程", "version 1.0", "", "Bin Swagger","com.bin", "http://localhost:8085/login");
    }

    @Bean
    public Docket docket(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Auth").description("token 验证").modelRef(new ModelRef("string")).parameterType("header").build();

        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                .globalOperationParameters(parameterList);
    }
}
