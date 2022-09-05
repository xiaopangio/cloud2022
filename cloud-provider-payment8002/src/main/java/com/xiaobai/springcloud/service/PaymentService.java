package com.xiaobai.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.springcloud.entity.Payment;

public interface PaymentService extends IService<Payment> {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
