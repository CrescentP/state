package com.caopeng.state.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*首页是登录页面*/
        registry.addViewController("/").setViewName("Login");
        registry.addViewController("/admin/").setViewName("admin/Login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginHandlerInterceptor()).addPathPatterns("/admin/**")
                .excludePathPatterns("admin/Login.html","/admin/Login","/admin/goLogin","/static/**");

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/Login.html","/Login","/goLogin","/css/**","/echarts/**","/images/**","/is/**","/layui/**","/register","/register.html","/saveUser");


    }

}
