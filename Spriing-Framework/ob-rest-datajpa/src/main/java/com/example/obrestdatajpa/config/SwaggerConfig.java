package com.example.obrestdatajpa.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

//Configuracion Swagger para la generacion de documentacion de la API REST
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Book API",
                "Library Api wRest docs",
                "1.0",
                "http://www.google.com",
                new Contact("Gabriel", "http://www.google.com", "palmarthc@gmail.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}
