package uc.cs;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("//").allowedOrigins("*")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/resources/");
    }

}
