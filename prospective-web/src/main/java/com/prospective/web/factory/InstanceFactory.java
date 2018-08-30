package com.prospective.web.factory;

import com.prospective.web.entity.Student;

public class InstanceFactory {
    public Student getStudent() {
        return new Student();
    }
}
