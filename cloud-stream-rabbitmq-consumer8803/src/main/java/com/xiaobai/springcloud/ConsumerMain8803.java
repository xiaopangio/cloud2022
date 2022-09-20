package com.xiaobai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * className: ConsumerMain8802
 * description:
 * author: xiaopangio
 * date: 2022/9/17 17:21
 * version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8803.class, args);
    }
}
