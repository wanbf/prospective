package com.design.pattern.adapter;

/**
 * 对象的适配器
 */
class Source {
    public void method1() {
        System.out.println("this is original method!");
    }
}

interface TargetTable {

    /* 与原类中的方法相同 */
    void method1();

    /* 新类的方法 */
    void method2();
}

class Wrapper implements TargetTable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}

public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        TargetTable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
