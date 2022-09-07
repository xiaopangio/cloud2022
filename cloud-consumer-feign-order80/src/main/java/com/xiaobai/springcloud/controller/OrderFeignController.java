package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.entity.Payment;
import com.xiaobai.springcloud.entity.result.CommonResult;
import com.xiaobai.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * className: OrderFeignController
 * description:
 * author: xiaopangio
 * date: 2022/9/7 18:00
 * version: 1.0
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
