package com.prospective.config;

import com.prospective.custorm.LinuxCondition;
import com.prospective.bean.Person;
import com.prospective.custorm.MyBeanDefiitionRegistrar;
import com.prospective.custorm.MyImportSelector;
import com.prospective.custorm.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author wanbf
 * @date 2019/4/12 20:11
 */
@Configuration
//@Import(Color.class)
//@Import(MyImportSelector.class)
//@Import(MyBeanDefiitionRegistrar.class)
public class MainConfig2 {

    @Bean
    @Scope("prototype")
    //@Scope("singleton")
    @Lazy
    @Conditional(WindowsCondition.class)
    public Person person2() {
        System.out.println("添加bean2实例....................");
        return new Person(22, "lisi");
    }

    @Bean
    @Scope("prototype")
    //@Scope("singleton")
    @Lazy
    @Conditional(LinuxCondition.class)
    public Person person1() {
        System.out.println("添加bean1实例....................");
        return new Person(25, "zhangsan");
    }
}
