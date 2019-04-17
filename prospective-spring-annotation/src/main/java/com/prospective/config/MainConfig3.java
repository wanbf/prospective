package com.prospective.config;

import com.prospective.bean.Color;
import com.prospective.bean.ColorFactoryBean;
import com.prospective.bean.Person;
import com.prospective.custorm.LinuxCondition;
import org.springframework.context.annotation.*;

/**
 * @author wanbf
 * @date 2019/4/13 10:45
 */
@Configuration
@ComponentScan("com.prospective.controller")
public class MainConfig3 {
    @Bean
    @Scope("singleton")
    @Lazy
    public Person person1() {
        System.out.println("添加bean1实例....................");
        return new Person(25, "zhangsan");
    }
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
