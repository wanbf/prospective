package com.angel.prospective.util.loader;

/**
 * @author wanbf
 * @date 2019/1/23 11:48
 */
@LoadLevel(name = "second", order = -1)
public class ThirdLoader implements LoaderService {
    @Override
    public void test() {
        System.out.println("this is my third loader");

    }
}
