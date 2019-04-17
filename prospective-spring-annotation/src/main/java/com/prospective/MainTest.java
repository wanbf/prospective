package com.prospective;

import com.prospective.bean.ColorFactoryBean;
import com.prospective.config.MainConfig2;
import com.prospective.bean.Person;
import com.prospective.config.MainConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanbf
 * @date 2019/4/11 19:04
 */
public class MainTest {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        //System.out.println(context.getBean(Person.class));
        //  String[] names = context.getBeanNamesForType(Person.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getEnvironment().getProperty("os.name"));

        System.out.println(context.getBean(ColorFactoryBean.class).getObjectType());
        System.out.println(context.getBean("colorFactoryBean").getClass());
        System.out.println(context.getBean("&colorFactoryBean").getClass());
    }
}
