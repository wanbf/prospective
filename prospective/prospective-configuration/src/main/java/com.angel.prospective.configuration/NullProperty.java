package com.angel.prospective.configuration;

/**
 * Created by wanbf on 2017/11/17.
 */
public final class NullProperty implements Property {

    public static final String NULL_KEY = "null_property_key";

    private String key;

    public static NullProperty INSTANCE = new NullProperty();

    private NullProperty() {
        key = NULL_KEY;
    }

    public String key() {
        return key;
    }

    public String value() {
        return null;
    }

    @Override
    public String toString() {
        return "key:null,value:null";
    }
}
