package com.prospective.web;

import com.prospective.web.dao.StudentDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class StudentLoggingProxy {

    private Object target;

    public StudentLoggingProxy(Object target) {
        this.target = target;
    }

    public Object getStudentProxy() {
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{StudentDao.class};
        InvocationHandler h = (proxy1, method, args) -> {
            System.out.println("start");
            Object obj = method.invoke(target, args);
            System.out.println("end");
            return obj;
        };
        return Proxy.newProxyInstance(loader, interfaces, h);
    }
}
