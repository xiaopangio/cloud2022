package com.xiaobai.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: PaymentController
 * description:
 * author: xiaopangio
 * date: 2022/9/5 19:31
 * version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "com.xiaobai.springcloud with consul: "+serverPort+"\t"+System.currentTimeMillis();
    }
}
