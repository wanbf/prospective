package com.design.pattern.simplefactory;

/**
 * 简单工厂又称作为静态工厂模式
 */
public class Main {
    public static void main(String[] args) {
        Product1 product1 = Factory.createP1();
        product1.product();
    }
}
