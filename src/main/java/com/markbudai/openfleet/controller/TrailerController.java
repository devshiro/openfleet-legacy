package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.services.TrailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Mark on 2017. 04. 26..
 */
@Controller
public class TrailerController {

    private TrailerService trailerService;

    private static Logger logger = LoggerFactory.getLogger(TrailerController.class);

    private static String viewPrefix = "trailer/";

    @Autowired
    public TrailerController(TrailerService provider){
        this.trailerService = provider;
    }

    @RequestMapping("/trailers/list")
    public String listTrailers(Model model){
        model.addAttribute("trailerList", trailerService.getAllTrailers());
        model.addAttribute("path","/trailers/list");
        model.addAttribute("title","Trailers");
        model.addAttribute("supervisionList", trailerService.getSupervisionList());
        return viewPrefix+"listTrailers";
    }

    @RequestMapping("/trailer")
    public String getDetails(@RequestParam("id") long id, Model model){
        model.addAttribute("path","/trailer");
        model.addAttribute("title","Trailer Details");
        model.addAttribute("trailer", trailerService.getTrailerById(id));
        return viewPrefix+"trailerDetails";
    }

    @RequestMapping("/trailer/delete")
    public String sellTrailer(@RequestParam("id") long id, Model model){
        trailerService.sellTrailer(id);
        return listTrailers(model);
    }

    @PostMapping("/trailer/add")
    public String addTrailer(Model model, WebRequest request){
        logger.info("Starting trailer adding / updating method.");
        logger.debug("Id is: {}",request.getParameter("id"));
        trailerService.addOrUpdate(request);
        return listTrailers(model);
    }

    @RequestMapping("/trailer/new")
    public String newTrailer(Model model){
        model.addAttribute("title","Trailer form");
        return viewPrefix+"trailerDetails";
    }
}