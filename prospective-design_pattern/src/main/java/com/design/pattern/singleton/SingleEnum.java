package com.design.pattern.singleton;


/**
 * 枚举就是单例，避免反射和反序列化的漏洞
 * 缺点：没有懒加载机制
 */
public enum SingleEnum {
    INSTANCE;
}

