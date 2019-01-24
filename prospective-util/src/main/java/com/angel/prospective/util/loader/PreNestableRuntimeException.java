package com.angel.prospective.util.loader;


import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * @author wanbf
 * @date 2019/1/23 11:20
 */
public class PreNestableRuntimeException extends NestableRuntimeException {
    private static final long serialVersionUID = 7748438218914409019L;

    public PreNestableRuntimeException(String errorCode) {
        super(errorCode);
    }

    public PreNestableRuntimeException(Throwable cause) {
        super(cause);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
