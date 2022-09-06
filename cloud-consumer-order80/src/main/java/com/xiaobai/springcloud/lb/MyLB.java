package com.xiaobai.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * className: MyLB
 * description:
 * author: xiaopangio
 * date: 2022/9/6 19:02
 * version: 1.0
 */
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current= atomicInteger.get();
            next=current>=Integer.MAX_VALUE?0:current+1;
            if(atomicInteger.compareAndSet(current,next))
                return next;
        }while (true);
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index =getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
