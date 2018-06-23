package com.angel.prospective.common.serializer;

/**
 * Created by wanbf on 2017/11/21.
 */
public class SerializationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SerializationException(Exception ex) {
        super(ex);
    }

    public SerializationException(String message, Exception ex) {
        super(message, ex);
    }

}
