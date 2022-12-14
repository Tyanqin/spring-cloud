package com.tx.annotation;

/**
 * Created by malong on 2018/2/25.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 中心服务鉴权
 * Created by ace on 2017/9/27.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface CheckCenterToken {
}
