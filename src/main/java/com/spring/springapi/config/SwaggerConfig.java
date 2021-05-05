package com.spring.springapi.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        Parameter authHeader = new ParameterBuilder()
            .parameterAccess("Notification-controller")
            .parameterType("header")
            .name("Authorization")
            .modelRef(new ModelRef("string"))
            .build();



        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .build()
            .globalOperationParameters(Collections.singletonList(authHeader));





    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("Employee Profile API")
            .description("This API can be used to get profile level actions and information for an employee")
            .version("V1.0")
            .build();
    }
}
