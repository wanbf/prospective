package com.prospective.web.factory;

import com.prospective.web.entity.Student;

public class FactoryBean implements org.springframework.beans.factory.FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
