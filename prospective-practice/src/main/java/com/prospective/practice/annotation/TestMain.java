package com.prospective.practice.annotation;


public class TestMain {

    public static void main(String[] args) throws IllegalAccessException {
        School sc = new School();
        sc.setStr1("s     \n  \r  \r\n   s");
        sc.setStr2("s     \n  \r  \r\n   s");
        sc.setStr3("s     \n  \r  \r\n   s");
        StringsUtil.removeCustomizeValue(sc);
        System.out.print(sc.getStr1() + "\n" + sc.getStr2() + "\n" + sc.getStr3());
    }
}
