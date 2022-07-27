package com.tx.data;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.tx.data.config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:TanXiao
 * @date:2022/7/19
 */
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.tx.data"})
@RibbonClient(name = "spring-cloud-data-v1",configuration = MyRuleConfig.class)
@EnableCircuitBreaker   //断路器
@EnableHystrix    //开启Hystrix
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableSwagger2Doc
public class SpringCloudDataClientApplication {
    public static void main(String args[]){
        SpringApplication.run(SpringCloudDataClientApplication.class, args);
    }
}
