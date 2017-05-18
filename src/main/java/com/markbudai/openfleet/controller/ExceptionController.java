package com.markbudai.openfleet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mark on 2017. 05. 18..
 */

//TODO: FIX to properly show errors!!!!
@Controller
public class ExceptionController implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    private static String viewPrefix = "error/";

    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",ex);
        mav.addObject("url",req.getRequestURL());
        mav.setViewName(viewPrefix+"index");
        return mav;
    }
}
