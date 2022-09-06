package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.entity.Payment;
import com.xiaobai.springcloud.entity.result.CommonResult;
import com.xiaobai.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * className: OrderController
 * description:
 * author: xiaopangio
 * date: 2022/9/3 19:53
 * version: 1.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController  {
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalance loadBalance;
    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null||instances.size()<=0){
            return null;
        }
        ServiceInstance instance = loadBalance.instances(instances);
        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }
}
