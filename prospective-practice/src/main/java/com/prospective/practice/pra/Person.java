package com.prospective.practice.pra;

/**
 * Created by wanbf on 2018/4/25.
 */
public class Person {
    private final int id;
    private final int age;
    private final String name;
    private final String sex;
    private final String desc;
    private final String phone;

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.desc = builder.desc;
        this.phone = builder.phone;
    }

    public static class Builder {
        private final int id;
        private final String name;
        private int age;
        private String sex;
        private String desc;
        private String phone;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }

    public String getPhone() {
        return phone;
    }
}

class Test1 {
    public static void main(String[] args) {
        Person person = new Person.Builder(1, "test")
                .age(11)
                .phone("12")
                .sex("nan")
                .desc("nice")
                .build();
        System.out.println(person.getName());
    }
}