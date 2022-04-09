package com.divyansh.xharktank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081", "http://xharktank.crio.do/", "https://xharktank.crio.do/")
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.OPTIONS.name())
                .maxAge(3600);
    }
}
