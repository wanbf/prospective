package com.design.pattern.factory;

public class Main {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct product = factory.crateProduct();
        product.productMethod();
    }
}
