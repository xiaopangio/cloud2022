package com.xiaobai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * className: NacosOrderMain80
 * description:
 * author: xiaopangio
 * date: 2022/9/20 11:37
 * version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain80.class, args);
    }
}
