package com.angel.prospective.util.loader;

/**
 * @author wanbf
 * @date 2019/1/23 11:39
 */
@LoadLevel(name = "default", order = 0)
public class DefaultLoaderService implements LoaderService {
    @Override
    public void test() {
        System.out.println("this is my default loader");
    }
}
