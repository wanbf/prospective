package com.design.pattern.singleton;

/**
 * 懒-加载
 */
public class SingleStatic {
    private SingleStatic() {

    }

    public SingleStatic getInstance() {
        return SingleInstanceClass.Instance;
    }

    private static class SingleInstanceClass {
        public static final SingleStatic Instance = new SingleStatic();
    }
}
