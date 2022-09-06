package com.xiaobai.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className: RibbonConfig
 * description:
 * author: xiaopangio
 * date: 2022/9/6 10:50
 * version: 1.0
 */
@Configuration
public class RibbonConfig {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
