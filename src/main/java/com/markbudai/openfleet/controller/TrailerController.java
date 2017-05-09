package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.model.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 26..
 */
@Controller
public class TrailerController {

    @Autowired
    private TrailerProvider trailerProvider;

    @RequestMapping("/trailers/list")
    public String listTrailers(Model model){
        model.addAttribute("trailerList",trailerProvider.getAllTrailers());
        model.addAttribute("path","/trailers/list");
        model.addAttribute("title","Trailers");
        return "listTrailers";
    }

    @RequestMapping("/trailer")
    public String getDetails(@RequestParam("id") long id, Model model){
        model.addAttribute("path","/trailer");
        model.addAttribute("title","Trailer Details");
        model.addAttribute("trailer",trailerProvider.getTrailerById(id));
        return "trailerDetails";
    }
}