package com.markbudai.openfleet.controller;


import com.markbudai.openfleet.dao.providers.TractorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mark on 2017. 04. 19..
 */
@Controller
public class TractorController {

    @Autowired
    private TractorProvider tractorProvider;


    @RequestMapping("/tractors/list")
    public String listTractors(Model model){
        model.addAttribute("path","/tractors/list");
        model.addAttribute("title","Tractors");
        model.addAttribute("tractorList",tractorProvider.getAllTractors());
        return "listTractors";
    }

    @RequestMapping("/tractor")
    public String getDetails(@RequestParam("id") long id, Model model){
        model.addAttribute("path","/tractor");
        model.addAttribute("title","Tractor Details");
        model.addAttribute("tractor",tractorProvider.getTractorById(id));
        return "tractorDetails";
    }
}
