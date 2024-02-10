package org.example;

import org.example.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> loggingFilter(){
        FilterRegistrationBean<AuthFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthFilter());
        registrationBean.addUrlPatterns("/user/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("/*/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("POST, PUT, GET, OPTIONS, DELETE,PATCH, HEAD").allowedOrigins("http://localhost:4200");
            }
        };
    }

}