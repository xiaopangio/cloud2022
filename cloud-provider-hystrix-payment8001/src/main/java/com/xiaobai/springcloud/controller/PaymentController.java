package com.xiaobai.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaobai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * className: PaymentController
 * description:
 * author: xiaopangio
 * date: 2022/9/9 9:58
 * version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")int id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("result:{}",result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")int id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("result:{}",result);
        return result;
    }
}
