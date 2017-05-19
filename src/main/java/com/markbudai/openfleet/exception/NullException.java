package com.markbudai.openfleet.exception;

import java.lang.reflect.Method;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class NullException extends RuntimeException {
    public NullException(Class m){
        super(new StringBuilder()
                .append("NullPointer method parameter [ ")
                .append(m.toString()).append(" ]").toString());
    }
}
