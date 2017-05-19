package com.markbudai.openfleet.exception;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(Class c){
        super(new StringBuilder().append("No ")
        .append(c.toString())
        .append(" object found!").toString());
    }
}
