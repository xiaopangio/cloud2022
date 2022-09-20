package com.xiaobai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloudalibaba-provider-payment")
public interface PaymentService {
    @GetMapping(value = "/payment/nacos")
    public String getPayment();
}
