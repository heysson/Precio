package com.between.precio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;
 

@Configuration
public class SpringFoxConfig {
 
 
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API - Prices",
                "Prices",
                "1.0",
                "",
                new Contact("Precies", "https://google.com", "apis@Prueba.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
 
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.between.precio"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
}