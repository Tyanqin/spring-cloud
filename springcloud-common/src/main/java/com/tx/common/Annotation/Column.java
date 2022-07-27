package com.tx.common.Annotation;

import java.lang.annotation.*;

/**
 * @author TanXiao
 * @date 2022-05-21 09:25
 */

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String value();
}
