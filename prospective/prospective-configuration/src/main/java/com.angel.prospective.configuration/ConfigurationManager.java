package com.angel.prospective.configuration;

/**
 * Created by wanbf on 2017/11/17.
 */
public interface ConfigurationManager {

    String getPropertyValue(String key);

    Property getProperty(String key);


}
