package com.prospective.practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

/**
 * @author wanbf
 * @date 2019/4/11 11:30
 */
public class ClassLoaderTest extends URLClassLoader {
    public ClassLoaderTest(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public static void main(String[] args) throws Exception {
        ClassLoaderTest test = new ClassLoaderTest(new URL[]{}, findParentClassLoader());
        /*String urlStr="file://D://lvmm_order_search_api_0.0.1_SNAPSHOT.jar";
        URL url =  new URL(urlStr);*/
        File file = new File("D://lvmm_order_search_api_0.0.1_SNAPSHOT.jar");
        URL url =  file.toURI().toURL();
        test.addURL(url);
        Class CommentToReback = Class.forName("com.lvmama.order.search.vo.CommentToReback");
        System.out.println(CommentToReback);
    }

    private static ClassLoader findParentClassLoader() {
        ClassLoader parent = ClassLoaderTest.class.getClassLoader();
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        return parent;
    }
}
