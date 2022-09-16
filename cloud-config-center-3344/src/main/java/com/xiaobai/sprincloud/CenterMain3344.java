package com.xiaobai.sprincloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * className: CenterMain3344
 * description:
 * author: xiaopangio
 * date: 2022/9/16 15:29
 * version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class CenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CenterMain3344.class,args);
    }
}
