package com.prospective.practice.spring.annotation;

import java.lang.annotation.*;

/**
 * Created by wanbf on 2018/5/25.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZxfResource {
    String name() default "";
}