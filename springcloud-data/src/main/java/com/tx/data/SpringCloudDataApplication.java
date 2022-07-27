package com.tx.data;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author:TanXiao
 * @date:2022/7/18
 */
@RefreshScope
@SpringBootApplication(exclude = {})
@EnableEurekaClient
@EnableSwagger2Doc
@MapperScan("com.tx.data.dao")
//@EnableCircuitBreaker
public class SpringCloudDataApplication {
    public static void main(String args[]){
        SpringApplication.run(SpringCloudDataApplication.class,args);
    }

//    /**
//     * 此配置是为了服务监控而配置，与服务容错本身无观，springCloud 升级之后的坑
//     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
//     * 只要在自己的项目中配置上下面的servlet即可
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean getServlet(){
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/hystrix.stream");
//        registrationBean.setName("HystrixMetricsStreamServlet");
//        return registrationBean;
//    }

}
