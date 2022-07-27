package com.tx.data.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * @author:TanXiao
 * @date:2022/6/8
 */
public class IRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
    @Override
    public Server choose(Object key) {
        return null;
    }
}
