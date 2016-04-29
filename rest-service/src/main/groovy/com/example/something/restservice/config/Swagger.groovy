package com.example.something.restservice.config

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage

/**
 * Spring configuration component: Configures springfox/swagger
 */
@Configuration
@EnableSwagger2
@CompileStatic
class Swagger {
    @Bean
    Docket api() {
        def apiInfo = new ApiInfoBuilder()
                .title("Sample REST spring-boot webapp API")
                .description("Webapp short description.")
                .contact(new Contact("Joe Average", "http://example.com/", "joe.average@example.com"))
                .build()

        new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(getApiRoot()))
                .build()
                .apiInfo(apiInfo)
    }

    private String getApiRoot() {
        def pkgChunks = getClass().getPackage().getName().split("\\.").toList()
        pkgChunks.pop()
        pkgChunks.join(".")
    }
}
