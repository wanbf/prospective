package com.angel.prospective.configuration;

import com.angel.prospective.common.value.NullArgumentChecker;

/**
 * Created by wanbf on 2017/11/17.
 */
public class DefaultProperty implements Property {

    private ConfigurationManager manager;
    private String key;

    public DefaultProperty(ConfigurationManager manager, String key) {
        NullArgumentChecker.DEFAULT.check(manager, "manager");
        NullArgumentChecker.DEFAULT.check(key, "key");
        this.manager = manager;
        this.key = key;
    }

    protected ConfigurationManager manager() {
        return manager;
    }

    public String key() {
        return key;
    }

    public String value() {
        return manager.getPropertyValue(key);
    }

    @Override
    public String toString() {
        return String.format("{ key: %s, value: %s }", key(), value());
    }
}
