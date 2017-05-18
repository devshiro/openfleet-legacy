package com.markbudai.openfleet.exception;

import org.springframework.web.context.request.WebRequest;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class EmptyParameterException extends RuntimeException {
    public EmptyParameterException(String parameter){
        super(String.format("No %s parameter provided.",parameter));
    }
}
