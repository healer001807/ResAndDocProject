package com.vv.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: ResAndSwaggerProject
 * @description: 接口文档自动扫描配置
 * @author: kangwei
 * @create: 2023-05-24 11:21
 **/
@Configuration
public class SpringDocConfig {
    /*** 
     * @description 注入openAPI
     * @author kangwei
     * @date 2023-5-24
     * @param
     @return io.swagger.v3.oas.models.OpenAPI
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Spring Boot3 Restful  API")
                        .description(" Animal Detail APi")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Wiki Documentation")
                        .url("https://springdoc.org/v2"));
    }
}
