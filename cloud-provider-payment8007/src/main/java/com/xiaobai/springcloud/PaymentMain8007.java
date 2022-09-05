package com.xiaobai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * className: PaymentMain8007
 * description:
 * author: xiaopangio
 * date: 2022/9/5 20:00
 * version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8007.class, args);
    }
}
