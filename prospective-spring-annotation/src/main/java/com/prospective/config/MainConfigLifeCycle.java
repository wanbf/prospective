package com.prospective.config;

import com.prospective.bean.Car;
import com.prospective.bean.Dog;
import com.prospective.custorm.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanbf
 * @date 2019/4/13 10:56
 * init 和destroy方法
 * InitializingBean,DisposableBean
 * @ PostConstruct @PreDestroy
 * BeanPostProcessor  postProcessBeforeInitialization postProcessAfterInitialization
 */
@Configuration
//@ComponentScan
public class MainConfigLifeCycle {
    @Bean
    // @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    /*@Bean
    public Cat cat(){
        return new Cat();
    }*/
    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public MyBeanPostProcessor beanostProcessor() {
        return new MyBeanPostProcessor();
    }
}
