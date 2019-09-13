// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.config;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import com.google.common.base.Predicates;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerMvcConfig
{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error"))).build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo("icon server", "REST API swagger", "1.0.0", "", new Contact("", "", ""), "Apache License Version 2.0", "https://github.com/springfox/springfox/blob/master/LICENSE");
    }
}
