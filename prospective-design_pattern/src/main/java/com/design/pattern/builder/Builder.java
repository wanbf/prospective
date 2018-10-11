package com.design.pattern.builder;

public abstract class Builder {

    public abstract Product build();

    public abstract void setArgs(String name, String type);
}
