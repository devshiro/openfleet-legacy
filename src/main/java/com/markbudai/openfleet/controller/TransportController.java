package com.markbudai.openfleet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
public class TransportController {

    private static Logger logger = LoggerFactory.getLogger(TransportController.class);

    @Autowired
    public TransportController(){
    }
}
