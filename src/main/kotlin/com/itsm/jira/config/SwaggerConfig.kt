package com.itsm.jira.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {
    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itsm.jira"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo())
    }

    private fun metaInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Jira like application")
                .description("\"Spring Boot REST API application\"")
                .version("1.0.0")
                .contact(Contact("Aleksey Makshun", "https://www.itsupportme.by", "amakshun@itsupportme.com"))
//                .license("GNU")
//                .licenseUrl("https://www.itsupportme.by\"")
                .build();

    }
}