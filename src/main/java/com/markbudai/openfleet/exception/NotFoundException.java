package com.markbudai.openfleet.exception;

/**
 * Exception which is thrown whenever a requested class is null.
 */
public class NotFoundException extends RuntimeException {
    /**
     * Constructs a NotFoundException.
     * @param klass the Class which is null or missing.
     */
    public NotFoundException(Class klass){
        super(new StringBuilder().append("No ")
        .append(klass.toString())
        .append(" object found!").toString());
    }
}
