package com.design.pattern.factory;

public class Factory implements IFactory {
    @Override
    public IProduct crateProduct() {
        return new Product();
    }
}
