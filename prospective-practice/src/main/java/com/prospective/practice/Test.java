package com.prospective.practice;

/**
 * Created by wanbf on 2018/3/29.
 */
public class Test implements Comparable<Test2> /*implements Cloneable*/ {

    private Test2 test2;
    private String[] names = new String[5];
    private int age;

    public Test(Test2 test2, int age) {
        this.test2 = test2;
        this.age = age;
    }

    public void addName(String name, String name1) {
        names[0] = name;
        names[1] = name1;
    }

    public void setName(String name) {
        names[0] = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Test2 o) {
        return 0;
    }

 /*   @Override
    public Object clone() {
        Test t12 = null;
        try {
            t12 = (Test) super.clone();
            String[] names1 = names.clone();
            t12.names = names1;
            Test2 tt = (Test2) test2.clone();
            t12.test2 = tt;
            return t12;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}


class Test2 implements Cloneable {
    private String t2;

    public Test2(String t2) {
        this.t2 = t2;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Test3 implements Cloneable {
    private String name;

    public Test3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
