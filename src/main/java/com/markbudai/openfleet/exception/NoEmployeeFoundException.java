package com.markbudai.openfleet.exception;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class NoEmployeeFoundException extends RuntimeException {
    public NoEmployeeFoundException(long id){
        super("No employee found with id "+id);
    }
}
