package com.xiaobai.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * className: OrderConsulController
 * description:
 * author: xiaopangio
 * date: 2022/9/5 19:52
 * version: 1.0
 */
@RestController
public class OrderConsulController {
    private static final String INOVKE_URL = "http://consul-provider-service";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INOVKE_URL+"/payment/consul",String.class);
    }

}
