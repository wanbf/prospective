package com.prospective.web.factory;

import com.prospective.web.entity.Student;

public class StaticFactory {
    public static Student getStudent() {
        return new Student();
    }
}
