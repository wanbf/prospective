package com.angel.prospective.util.loader;

/**
 * @author wanbf
 * @date 2019/1/23 11:42
 */
public class LoaderTest {
    public static void main(String[] args) {
        LoaderService service = ProspectiveLoader.load(LoaderService.class);
        service.test();
    }
}
