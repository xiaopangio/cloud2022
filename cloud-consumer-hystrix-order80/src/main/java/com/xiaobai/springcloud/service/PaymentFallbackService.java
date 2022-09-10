package com.xiaobai.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * className: PaymentFallbackService
 * description:
 * author: xiaopangio
 * date: 2022/9/10 9:57
 * version: 1.0
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(int id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
