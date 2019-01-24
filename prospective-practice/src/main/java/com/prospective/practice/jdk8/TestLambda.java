package com.prospective.practice.jdk8;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wanbf
 * @date 2018/12/10 18:45
 */
public class TestLambda {
    public static void main(String[] args) {
        Comparator comparator = (o1, o2) -> {
            if (o1 == o2)
                return 1;
            return 0;
        };

        Comparator comparator1 = (o1, o2) -> 0;

        List<Employee> list = Arrays.asList(new Employee(1,1),new Employee(2,2));

    }
}

class Employee{
    int age;
    int salary;

    public Employee(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
