package com.bistu.secondhandtradeplatform.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Value("${slide.upload.path}")
    private String slideUploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/pic/**").addResourceLocations("file:"+fileUploadPath);
        registry.addResourceHandler("/slide/**").addResourceLocations("file:"+slideUploadPath);
        System.out.println("file:"+fileUploadPath);
        System.out.println("file:"+slideUploadPath);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 设置允许请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 预请求的结果能被缓存多久
                .maxAge(3600)
                // 设置允许的请求头
                .allowedHeaders("*");
    }
}
