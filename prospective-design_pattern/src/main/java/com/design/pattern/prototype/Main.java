package com.design.pattern.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Apple apple = new Apple();
        apple.setNum(10);
        Apple apple1 = (Apple) apple.clone();
        System.out.println(apple1.getNum());
        apple1.setNum(11);
        System.out.println(apple.getNum());
        System.out.println(apple1.getNum());

    }
}
