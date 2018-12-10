package com.design.pattern.builder;

public class ConcreteBuilder extends Builder {

    Product product = new Product();

    @Override
    public Product build() {
        return product;
    }

    @Override
    public void setArgs(String name, String type) {
        product.setName(name);
        product.setType(type);
    }
}
