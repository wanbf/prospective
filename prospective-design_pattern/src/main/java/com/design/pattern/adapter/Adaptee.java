package com.design.pattern.adapter;

/**
 * 类的适配器
 */
public class Adaptee {
    public void sampleOperation1() {
        System.out.println("Adaptee sampleOperation1");
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.sampleOperation2();
        adapter.sampleOperation1();
    }
}

interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法
     */
    void sampleOperation2();
}

class Adapter extends Adaptee implements Target {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        System.out.println("Adapter sampleOperation2");
    }

}