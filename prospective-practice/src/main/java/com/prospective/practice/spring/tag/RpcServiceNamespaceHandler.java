package com.prospective.practice.spring.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by wanbf on 2018/5/24.
 */
public class RpcServiceNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("publish", new RpcServicePublishBeanDefinitionParser());
    }}