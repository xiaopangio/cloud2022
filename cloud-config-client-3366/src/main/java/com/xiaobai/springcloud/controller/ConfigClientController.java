package com.xiaobai.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: ConfigClientController
 * description:
 * author: xiaopangio
 * date: 2022/9/17 10:06
 * version: 1.0
 */

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
