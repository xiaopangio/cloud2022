package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.entity.Payment;
import com.xiaobai.springcloud.entity.result.CommonResult;
import com.xiaobai.springcloud.entity.result.ResultCode;
import com.xiaobai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * className: PaymentController
 * description:
 * author: xiaopangio
 * date: 2022/9/3 18:55
 * version: 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result>0){
            log.info("通过端口："+serverPort+"插入成功");
            return new CommonResult<Integer>(ResultCode.SUCCESS,result);
        }
        return new CommonResult<Integer>(ResultCode.FAIL);
    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if(payment!=null){
            log.info("通过端口："+serverPort+"查询成功");
            return new CommonResult<Payment>(ResultCode.SUCCESS,payment);
        }
        return new CommonResult<Payment>(ResultCode.FAIL);
    }
    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
