package com.xiaobai.springcloud.service;

import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * className: PaymentService
 * description:
 * author: xiaopangio
 * date: 2022/9/9 9:46
 * version: 1.0
 */
@Service
public class PaymentService {

    /**
     * 付款信息好了
     *
     * @param id id
     * @return {@link String}
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O哈哈~";
    }
    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a=5/0;
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时"+timeNumber+"秒钟";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id: "+id+"\t"+"o(╥﹏╥)o";
    }
    //服务熔断，对于以下的配置，是指在10秒内，如果有10个请求，其中60%的请求失败了，那么就会触发熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功：流水号： "+serialNumber;
    }
    public String paymentCircuitBreakerFallback(Integer id){
        return "id不能为负数，o(╥﹏╥)o  id："+id;
    }
}
