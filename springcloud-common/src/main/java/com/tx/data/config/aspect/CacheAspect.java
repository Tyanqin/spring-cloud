package com.tx.data.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 浏览器缓存切面
 * @author:TanXiao
 * @date:2022/7/19
 */
@Slf4j
@Aspect
@Component
@Order(2)
public class CacheAspect {


}

