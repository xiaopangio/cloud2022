package com.xiaobai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * className: ConfigClientMain3366
 * description:
 * author: xiaopangio
 * date: 2022/9/17 10:05
 * version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}
