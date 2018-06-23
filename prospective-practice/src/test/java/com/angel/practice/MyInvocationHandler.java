package com.angel.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wanbf on 2017/12/13.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler() {
        super();
    }

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("--------before " + method.getName() + "--------");
            Object result = method.invoke(target, args);
            System.out.println("--------after " + method.getName() + "--------");
            return result;
        } else {
            Object result = method.invoke(target, args);
            return result;
        }
    }


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
        System.out.println(userServiceProxy.getName(1));
    }
}

interface UserService {
    String getName(int id);

    Integer getAge(int id);
}

class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 10;
    }
}