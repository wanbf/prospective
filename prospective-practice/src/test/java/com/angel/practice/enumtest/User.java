package com.angel.practice.enumtest;

/**
 * Created by wanbf on 2017/12/22.
 */
public enum User {
    WANBF("wanbf", 27, 173);

    private String userName;
    private int age;
    private int height;

    User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    User(String userName, int age, int height) {
        this.userName = userName;
        this.age = age;
        this.height = height;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}
