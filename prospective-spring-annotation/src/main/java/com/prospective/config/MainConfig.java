package com.prospective.config;

import com.prospective.custorm.MyTypeFilter;
import com.prospective.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;

/**
 * @author wanbf
 * @date 2019/4/12 19:22
 * 配置类等等于xml
 */
@Configuration
@ComponentScan(value = "com.prospective",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)},
        includeFilters = {/*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),*/
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)}, useDefaultFilters = false)
public class MainConfig {

    @Bean(value = "person")
    @Scope("singleton")
    public Person person() {
        return new Person(12, "zhangsan");
    }

}
