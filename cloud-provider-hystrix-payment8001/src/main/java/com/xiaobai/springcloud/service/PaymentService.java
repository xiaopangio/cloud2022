package com.xiaobai.springcloud.service;

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
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=5;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int a=5/0;
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时"+timeNumber+"秒钟";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id: "+id+"\t"+"o(╥﹏╥)o";
    }
}
