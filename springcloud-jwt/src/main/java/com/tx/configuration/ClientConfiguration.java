package com.tx.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author:TanXiao
 * @date:2022/7/26
 */
@Configuration
@Data
public class ClientConfiguration {
    @Value("${center.token-header}")
    private String centerTokenHeader;

    @Value("${center.site.token-header}")
    private String siteTokenHeader;

    @Value("${jwt.token-header}")
    private String userTokenHeader;
}
