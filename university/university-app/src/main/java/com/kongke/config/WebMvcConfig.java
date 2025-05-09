package com.kongke.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kongke
 * @date 2025/04/06
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private AuthInterceptor authenticationInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor)
//                .addPathPatterns("/**");
////                .excludePathPatterns("/user/test");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 所有接口路径
            .allowedOrigins("*") // 允许所有来源（生产环境建议替换为具体域名）
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的HTTP方法
            .allowedHeaders("*") // 允许所有请求头
            .allowCredentials(false) // 是否允许发送Cookie（true时allowedOrigins不能为*）
            .maxAge(3600); // 预检请求缓存时间（秒）
    }
}


