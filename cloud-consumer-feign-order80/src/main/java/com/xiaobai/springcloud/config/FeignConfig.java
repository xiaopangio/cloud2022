package com.xiaobai.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className: FeignConfig
 * description:
 * author: xiaopangio
 * date: 2022/9/9 9:04
 * version: 1.0
 */
@Configuration
public class FeignConfig {
//    配置日志打印的级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
