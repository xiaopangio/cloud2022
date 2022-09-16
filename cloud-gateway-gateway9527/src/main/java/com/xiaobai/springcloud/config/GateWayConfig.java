package com.xiaobai.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className: GateWayConfig
 * description:
 * author: xiaopangio
 * date: 2022/9/15 16:31
 * version: 1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_xiaobai",r->r.path("/guonei").uri("https://news.baidu.com")).build();
        return routes.build();
    }
}
