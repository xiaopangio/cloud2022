package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * className: OrderHystrixController
 * description:
 * author: xiaopangio
 * date: 2022/9/9 15:07
 * version: 1.0
 */
@RestController
@RequestMapping("/consumer")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")int id){
        return paymentHystrixService.paymentInfo_OK(id);
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")int id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
}
