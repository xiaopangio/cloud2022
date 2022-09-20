package com.xiaobai.springcloud.controller;

import com.xiaobai.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * className: SendMessageController
 * description:
 * author: xiaopangio
 * date: 2022/9/17 16:38
 * version: 1.0
 */
@RestController
public class SendMessageController  {
    @Resource
    private IMessageService messageService;
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageService.send();
    }
}
