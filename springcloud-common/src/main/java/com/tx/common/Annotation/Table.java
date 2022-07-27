package com.tx.common.Annotation;

import java.lang.annotation.*;

/**
 * @author TanXiao
 * @date 2022-05-21 09:32
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
