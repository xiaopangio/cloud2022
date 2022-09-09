package com.xiaobai.springcloud.service;

import com.xiaobai.springcloud.entity.Payment;
import com.xiaobai.springcloud.entity.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * className: PaymentFeignService
 * description:
 * author: xiaopangio
 * date: 2022/9/7 17:55
 * version: 1.0
 */
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
