package com.prospective.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wanbf
 * @date 2019/4/13 10:42
 */
public class ColorFactoryBean  implements FactoryBean<Color>{

    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
