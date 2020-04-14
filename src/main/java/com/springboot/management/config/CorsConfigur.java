package com.springboot.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 */
@Configuration
public class CorsConfigur {
    //允许跨域访问的源服务器域名或ip地址
    private String[] orgins=new String[]{
            "localhost",
            "127.0.0.1",
            "localhost:8080"
    };

    @Bean
    public CorsFilter corsFilter(){
        //定义配置类，对跨域访问策略进行配置
        CorsConfiguration configuration=new CorsConfiguration();
        //添加允许的跨域源url
//        for(String origin:orgins){
//            configuration.addAllowedOrigin("http://"+origin);
//            configuration.addAllowedOrigin("https://"+origin);
//        }
        configuration.addAllowedOrigin("*");//开放url
        configuration.addAllowedMethod("*");//对请求方法不限制
        configuration.addAllowedHeader("*");
        //允许共享cookie和http认证信息
        //configuration.setAllowCredentials(true);
        //配置当前服务器下哪些路径下接口支持跨域策略
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }

}
