package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * className: OrderController
 * description:
 * author: xiaopangio
 * date: 2022/9/20 11:38
 * version: 1.0
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
//    @Value("${service-url.nacos-user-service}")
//    private String serverURL;
//    @GetMapping("/consumer/payment/nacos")
//    public String paymentInfo(){
//        return restTemplate.getForObject(serverURL+"/payment/nacos",String.class);
//    }
    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/payment/nacos")
    public String paymentInfo(){
        return paymentService.getPayment();
    }
}

