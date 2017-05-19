package com.markbudai.openfleet.exception;

import java.lang.reflect.Method;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class IncorrectMethodParameterException extends RuntimeException {
    public IncorrectMethodParameterException(Method m, Class c){
        super(new StringBuilder()
                .append("Incorrect method parameter [")
                .append(c.toString()).append(" ] in method [ ")
                .append(m.toString()).append(" ]").toString());
    }
}
