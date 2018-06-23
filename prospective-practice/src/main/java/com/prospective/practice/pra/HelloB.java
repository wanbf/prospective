package com.prospective.practice.pra;

import java.util.Arrays;

/**
 * Created by wanbf on 2018/1/31.
 */


public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new int[]{1,2,3}));
        new HelloA().sum(1);
        System.out.println("-------main start-------");
        new HelloB();
        new HelloB();
        System.out.println("-------main end-------");
    }
}

class HelloA {

    void sum(int... as) {
        for (int a : as)
            System.out.println("good");

    }

    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("static A");
    }

}