package com.angel.prospective.util.loader;

/**
 * @author wanbf
 * @date 2019/1/23 11:43
 */
@LoadLevel(name = "second", order = 1)
public class SecondLoader implements LoaderService{
    @Override
    public void test() {
        System.out.println("this is my second loader");
    }
}
