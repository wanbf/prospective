package com.angel.prospective.serialization.jdk.xml.javabean;

import java.io.Serializable;

public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 8745578444312339136L;

    public SerializableObject() {
    }

    public SerializableObject(int id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private int id;
    private String name;
    private double value;

}
