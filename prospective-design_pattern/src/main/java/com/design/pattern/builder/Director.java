package com.design.pattern.builder;

public class Director {

    public Product getCarProduct() {
        Builder builder = new ConcreteBuilder();
        builder.setArgs("小汽车", "car");
        return builder.build();
    }

    public Product getBusProduct() {
        Builder builder = new ConcreteBuilder();
        builder.setArgs("公交车", "bus");
        return builder.build();
    }
}
