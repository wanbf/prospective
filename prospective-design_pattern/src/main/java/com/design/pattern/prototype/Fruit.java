package com.design.pattern.prototype;

public abstract class Fruit implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
