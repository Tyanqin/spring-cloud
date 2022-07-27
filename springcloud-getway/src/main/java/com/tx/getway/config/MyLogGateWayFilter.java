package com.tx.getway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * GateWay全局过滤器
 * #{link}https://cloud.spring.io/spring-cloud-gateway/reference/html/#gatewayfilter-factories
 * @author:TanXiao
 * @date:2022/7/21
 */
@Configuration
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************filter**************"+new Date());
        String name = exchange.getRequest().getQueryParams().getFirst("uname");
        if(name == null){
            log.info("GateWay全局过滤器*******用户名空！非法用户********在yml配置之后执行");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
