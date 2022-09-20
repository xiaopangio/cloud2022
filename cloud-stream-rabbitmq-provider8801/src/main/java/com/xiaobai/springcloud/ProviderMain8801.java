package com.xiaobai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * className: ProviderMain8801
 * description:
 * author: xiaopangio
 * date: 2022/9/17 16:27
 * version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8801.class, args);
    }
}
