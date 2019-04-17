package com.prospective.practice;

import java.util.HashMap;

/**
 * @author wanbf
 * @date 2019/2/27 16:38
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"11");
        map.put(1,"12");
        map.put(2,"22");
        map.put(3,"33");
        map.put(4,"44");
        System.out.println(map.get(1));
        new Testss().test();
    }


}
class Testss{
    int age;

    public Testss(int age) {
        this.age = age;
    }

    public Testss() {
    }

    void test(){
        Testss a = new Testss(1);
        Testss b = a;
        a = new Testss(2);
        System.out.println(b.age);
    }
}

