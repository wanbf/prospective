package com.prospective.config;

import com.prospective.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wanbf
 * @date 2019/4/13 13:18
 */
@Configuration
@PropertySource(value = "classpath:person.properties")

public class MainConfigPropertyValue {
    @Bean
    public Person person() {
        return new Person();
    }
}
