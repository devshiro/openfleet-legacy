package com.markbudai.openfleet.exception;

import java.lang.reflect.Method;

/**
 * An exception which is thrown whenever a nullpointer is found.
 */
public class NullException extends RuntimeException {
    /**
     * Constructs a NullException.
     * @param klass the Class of the object which proven null.
     */
    public NullException(Class klass){
        super(new StringBuilder()
                .append("NullPointer method parameter [ ")
                .append(klass.toString()).append(" ]").toString());
    }
}
