package com.prospective.practice.pra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wanbf on 2018/4/11.
 */
public class Cs {
    private String a1 = "2";

    public static class Csa {
        public String a = "1";
    }

    public class Csb {
        public String b = "3";

        public Csb() {
            System.out.println(a1);
        }

        public void test() {
            class Csc {
                void cTest() {
                    System.out.println("4");
                }
            }
            new Csc().cTest();
        }


    }

    public <E> Set<E> getSet() {
        Set<E> set = new HashSet<>();
        return set;
    }

}

class CsTest {
    public static void main(String[] args) {
        Cs cs = new Cs();
        Set<String> set = cs.getSet();
        System.out.println(set.hashCode());
        Cs.Csa csa = new Cs.Csa();
        System.out.println(csa.a);

        Cs.Csb csb = new Cs().new Csb();
        System.out.println(csb.b);
        csb.test();

        ((Delete) () -> System.out.println("5")).delete();

        Test test = new Test();
        System.out.println(test.tt1(new Test("11")));
    }
}

interface Delete {
    void delete();
}

class Test {
    public Test() {
    }

    public Test(String tt) {
        this.tt = tt;
    }

    private String tt;

    public <E> String tt1(E e) {
        return ((Test) e).getTt();
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }
}

