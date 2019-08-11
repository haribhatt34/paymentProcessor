package com.example.demo.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
        		.apiInfo(metadata());
    }
    
    private ApiInfo metadata() {
        return new ApiInfo(
          "PaymentProcessor", 
          "These are APIs used for verification and validation of card requests", 
          "Incognito", 
          "Terms of service", 
          new Contact("Payplus", "www.comviva.com", "comviva@comviva.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
    
}

