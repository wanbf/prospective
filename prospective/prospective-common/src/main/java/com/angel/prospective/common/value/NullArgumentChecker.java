package com.angel.prospective.common.value;

/**
 * Created by wanbf on 2017/11/17.
 */
public class NullArgumentChecker implements ValueChecker<Object> {

    public static final NullArgumentChecker DEFAULT = new NullArgumentChecker();

    public void check(Object value, String valueName) {
        if (value == null)
            throw new IllegalArgumentException("argument " + valueName + "is null");
    }
}
