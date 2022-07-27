package com.tx;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author:TanXiao
 * @date:2022/7/18
 */
@SpringBootApplication
@EnableEurekaServer  //启动一个服务注册中心提供给其他应用进行对话
public class SpringCloudEureka7001 {
    public static void main(String args[]){
             new SpringApplicationBuilder(SpringCloudEureka7001.class).web(WebApplicationType.SERVLET).run(args);
    }
}
