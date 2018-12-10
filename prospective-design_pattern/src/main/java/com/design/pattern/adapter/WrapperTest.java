package com.design.pattern.adapter;

/**
 * 接口的适配器模式
 */
interface SourceAble {

    public void method1();

    public void method2();
}

abstract class Wrapper2 implements SourceAble {

    public void method1() {
        System.out.println("Wrapper2 method1");
    }

    public void method2() {
        System.out.println("Wrapper2 method2");
    }
}

class SourceSub1 extends Wrapper2 {
    public void method1() {
        System.out.println("SourceSub1 method1");
    }
}

class SourceSub2 extends Wrapper2 {
    public void method2() {
        System.out.println("SourceSub2 method2");
    }
}

public class WrapperTest {

    public static void main(String[] args) {
        SourceAble source1 = new SourceSub1();
        SourceAble source2 = new SourceSub2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}