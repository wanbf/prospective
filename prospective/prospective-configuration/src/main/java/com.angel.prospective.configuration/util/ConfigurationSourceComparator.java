package com.angel.prospective.configuration.util;

import com.angel.prospective.configuration.ConfigurationSource;

import java.util.Comparator;

/**
 * Created by wanbf on 2017/11/17.
 */
public class ConfigurationSourceComparator implements Comparator<ConfigurationSource> {

    public static final ConfigurationSourceComparator DEFAULT = new ConfigurationSourceComparator();

    private ConfigurationSourceComparator() {
    }

    public int compare(ConfigurationSource o1, ConfigurationSource o2) {
        if (o1 == o2)
            return 0;

        if (o1 == null)
            return 1;

        if (o2 == null)
            return -1;

        if (o1.priority() == o2.priority())
            return 0;

        return o1.priority() < o2.priority() ? 1 : -1;
    }
}
