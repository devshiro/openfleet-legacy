package com.markbudai.openfleet.exception;

/**
 * This is an exception that is thrown whenever a method gets a parameter which is null or empty.
 */
public class EmptyParameterException extends RuntimeException {
    /**
     * Constructs an EmptyParameterException.
     * @param parameter The name of the parameter which is null or empty.
     */
    public EmptyParameterException(String parameter){
        super(String.format("No %s parameter provided.",parameter));
    }
}
