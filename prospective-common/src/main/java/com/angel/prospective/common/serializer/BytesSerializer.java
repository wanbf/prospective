package com.angel.prospective.common.serializer;

/**
 * Created by wanbf on 2017/11/21.
 */
public interface BytesSerializer extends Serializer {

    byte[] serialize(Object obj);

    <T> T deserialize(byte[] is, Class<T> clazz);

}
