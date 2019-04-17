package com.prospective.practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author wanbf
 * @date 2019/4/11 11:36
 */
public class ClassLoadRelectTest {
    public static void main(String[] args) throws IOException {
        Class<? extends URLClassLoader> sysclass = URLClassLoader.class;
        try {
            File file = new File("D://lvmm_order_search_api_0.0.1_SNAPSHOT.jar");
            URL url = file.toURI().toURL();
            String urlStr = "file:/D:/lvmm_order_search_api_0.0.1_SNAPSHOT.jar";
            URL url1 = new URL(urlStr);
            Method method = sysclass.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke((URLClassLoader) ClassLoader.getSystemClassLoader(), url1);
            Class CommentToReback = Class.forName("com.lvmama.order.search.vo.CommentToReback");
            System.out.println(CommentToReback);
        } catch (Throwable t) {
            throw new IOException("Error, could not add URL to system classloader", t);
        }
    }
}
