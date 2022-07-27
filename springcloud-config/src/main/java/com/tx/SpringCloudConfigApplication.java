package com.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author:TanXiao
 * @date:2022/7/22
 */
@EnableConfigServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringCloudConfigApplication {
    public static void main(String args[]){
        SpringApplication.run(SpringCloudConfigApplication.class,args);
    }
}
