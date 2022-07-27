package com.tx.data.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:TanXiao
 * @date:2022/6/8
 */
@Configuration
public class MyRuleConfig {
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }

}
