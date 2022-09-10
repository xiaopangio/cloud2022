package com.xiaobai.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//@DefaultProperties(defaultFallback="payment_Global_FallbackMethod",commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//})
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")int id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")int id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
//    public String paymentInfo_TimeOutHandler(@PathVariable("id")int id){
//        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，/(ㄒoㄒ)/~~";
//    }
    //    全局fallback
//    public String payment_Global_FallbackMethod(){
//        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
//    }
}
