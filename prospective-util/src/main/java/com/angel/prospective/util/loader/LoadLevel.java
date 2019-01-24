package com.angel.prospective.util.loader;

import java.lang.annotation.*;

/**
 * @author wanbf
 * @date 2019/1/23 11:32
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface LoadLevel {
    String name();

    int order();
}
