package com.xiaobai.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: PaymentController
 * description:
 * author: xiaopangio
 * date: 2022/9/20 10:44
 * version: 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/nacos")
    public String getPayment(){
        return "nacos registry, serverPort: "+serverPort;
    }

}
