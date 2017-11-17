package com.angel.prospective.configuration;

import com.angel.prospective.common.value.CollectionValues;
import com.angel.prospective.configuration.util.ConfigurationSourceComparator;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wanbf on 2017/11/17.
 */
public class DefaultConfigurationManager implements ConfigurationManager {
    private static final Logger logger = LoggerFactory.getLogger(DefaultConfigurationManager.class);

    protected static final List<ConfigurationSource> EMPTY_CONFIGURATION_SOURCE_LIST = new ArrayList<ConfigurationSource>();

    private List<ConfigurationSource> sources;

    public DefaultConfigurationManager(ConfigurationSource... sources) {
        init(Lists.newArrayList(sources));
    }

    protected void init(List<ConfigurationSource> sources) {
        if (CollectionValues.isNullOrEmpty(sources)) {
            this.sources = EMPTY_CONFIGURATION_SOURCE_LIST;
            logger.warn("sources is null or empty");
            return;
        }
        this.sources = new ArrayList<ConfigurationSource>();
        for (ConfigurationSource source : sources) {
            if (source == null || source.configuration() == null)
                continue;
            this.sources.add(source);
        }
        Collections.sort(sources, ConfigurationSourceComparator.DEFAULT);
        StringBuffer sourceInfo = new StringBuffer("The sorted sources info");

    }

    public String getPropertyValue(String key) {
        return null;
    }

    public Property getProperty(String key) {
        return null;
    }
}
