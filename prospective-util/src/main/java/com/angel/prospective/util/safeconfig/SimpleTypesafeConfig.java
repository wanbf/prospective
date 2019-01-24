package com.angel.prospective.util.safeconfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author wanbf
 * @date 2019/1/23 10:04
 */
public class SimpleTypesafeConfig {
    private Config config;

    public SimpleTypesafeConfig(Config config) {
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "conf");
    }
    public SimpleTypesafeConfig() {
        this(ConfigFactory.load());
    }
    public void printSetting(String path) {
        System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }
    public static void main(String[] args) {
        SimpleTypesafeConfig s = new SimpleTypesafeConfig();
        s.printSetting("conf.foo");
        s.printSetting("properties.foo");
        s.printSetting("app.json");
    }
}
