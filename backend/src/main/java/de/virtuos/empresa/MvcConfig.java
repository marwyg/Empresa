package de.virtuos.empresa;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login/login");
        registry.addViewController("/").setViewName("dist/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/dist/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/templates/dist/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/templates/dist/fonts/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/templates/dist/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/templates/dist/js/");
        registry.addResourceHandler("/login/css/**").addResourceLocations("classpath:/templates/login/css/");
    }

}
