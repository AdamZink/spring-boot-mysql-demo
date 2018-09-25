package com.github.adamzink.springbootmysqldemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Primary
public class SwaggerConfiguration implements SwaggerResourcesProvider, WebMvcConfigurer {

    @Override
    public List<SwaggerResource> get() {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setLocation("/swagger/swagger.json");
        swaggerResource.setName("Spring Boot MySQL Demo API");

        return Collections.singletonList(swaggerResource);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("classpath:/swagger/");
    }
}
