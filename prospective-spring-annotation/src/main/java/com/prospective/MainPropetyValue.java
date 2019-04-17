package com.prospective;

import com.prospective.bean.Person;
import com.prospective.config.MainConfigLifeCycle;
import com.prospective.config.MainConfigPropertyValue;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanbf
 * @date 2019/4/13 13:18
 */
public class MainPropetyValue {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigPropertyValue.class);
        System.out.println(context.getBean(Person.class));
    }
}
