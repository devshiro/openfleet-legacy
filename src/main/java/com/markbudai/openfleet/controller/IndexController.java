package com.markbudai.openfleet.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 04. 14..
 */
@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("path","/");
        model.addAttribute("title","Dashboard");
        logger.debug("Serving Index page.");
        return "index";
    }
}