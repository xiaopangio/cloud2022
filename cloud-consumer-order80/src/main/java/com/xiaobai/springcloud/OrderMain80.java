package com.xiaobai.springcloud;

import com.xiaobai.springcloud.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * className: OrderMain80
 * description:
 * author: xiaopangio
 * date: 2022/9/3 19:50
 * version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = RibbonConfig.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
        System.out.println(111);
    }
}
