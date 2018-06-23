package com.angel.prospective.common.serializer;

/**
 * Created by wanbf on 2017/11/21.
 */
public interface StringSerializer {


    String serialize(Object obj);

    <T> T deserialize(String s, Class<T> clazz);
}
