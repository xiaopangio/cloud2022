package com.xiaobai.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaobai.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
