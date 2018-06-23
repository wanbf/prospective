package com.angel.prospective.common.serializer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wanbf on 2017/11/21.
 */
public interface StreamSerializer extends Serializer{

    void serialize(OutputStream os, Object obj);

    <T> T deserialize(InputStream is, Class<T> clazz);
}
