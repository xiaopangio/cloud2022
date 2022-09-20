package com.xiaobai.springcloud.service.impl;

import com.xiaobai.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * className: MessageProviderImpl
 * description:
 * author: xiaopangio
 * date: 2022/9/17 16:29
 * version: 1.0
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageService {
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial = " + serial);
        return null;
    }
}
