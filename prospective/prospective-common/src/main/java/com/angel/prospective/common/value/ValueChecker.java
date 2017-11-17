package com.angel.prospective.common.value;

/**
 * Created by wanbf on 2017/11/17.
 */
public interface ValueChecker<T> {

    void check(T value, String valueName);

}
