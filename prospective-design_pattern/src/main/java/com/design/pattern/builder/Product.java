package com.design.pattern.builder;

public class Product {

    private String name;
    private String type;

    public void show() {
        System.out.println("name : " + name + ", type : " + type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
