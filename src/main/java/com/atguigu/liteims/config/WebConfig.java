package com.atguigu.liteims.config;

import com.atguigu.liteims.interceptor.LoginIntegerceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //声明配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginIntegerceptor loginIntegerceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntegerceptor)
                .addPathPatterns("/api/**") //拦截哪些访问资源
                .excludePathPatterns("/api/login","/api/logout"); //放行哪些访问资源
    }
}
