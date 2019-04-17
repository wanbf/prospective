package com.prospective;

import com.prospective.config.MainConfigLifeCycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanbf
 * @date 2019/4/13 10:57
 */
public class MainLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        context.close();
    }
}
