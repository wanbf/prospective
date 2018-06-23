package com.angel.prospective.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wanbf on 2017/11/22.
 */
public abstract class Aspect implements InvocationHandler {

    private Object target;

    public Aspect(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public abstract boolean before(Object target, Method method, Object[] args);

    public abstract boolean after(Object target, Method method, Object[] args);

    public abstract boolean afterException(Object target, Method method, Object[] args, Throwable e);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 /*       Object result = null;
        if (before(target, method, args)) {
            try {
                result =
            }
        }*/
        return null;
    }

/*    private static <T> T invoke(Object obj, Method method, Object[] args) throws InvocationTargetException, IllegalArgumentException {
        if (false == method.isAccessible()) {
            method.setAccessible(true);
        }
        try {
            return (T) method.invoke(isStatic(method) ? null : obj, args);
        } catch (IllegalAccessException e) {
            throw e;
        }
    }*/
}