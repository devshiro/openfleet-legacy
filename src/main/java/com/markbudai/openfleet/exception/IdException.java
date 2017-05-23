package com.markbudai.openfleet.exception;

/**
 * This is an exception that is thrown whenever an incorrect or nonexisting id is provided.
 */
public class IdException extends RuntimeException {
    /**
     * Constructs an IdException.
     * @param id the id whick proven incorrect or nonexisting.
     */
    public IdException(long id){
        super(String.format("Incorrect id[ %s ] provided!",id));
    }
}
