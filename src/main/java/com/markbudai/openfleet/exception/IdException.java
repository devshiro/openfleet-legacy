package com.markbudai.openfleet.exception;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class IdException extends RuntimeException {
    public IdException(long id){
        super(String.format("Incorrect id[ %s ] provided!",id));
    }
}
