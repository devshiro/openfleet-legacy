package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Controller
public class LocationController {

    @Autowired
    private LocationProvider locationProvider;

    @RequestMapping("/locations/list")
    public String listLocations(Model model) {
        model.addAttribute("path","/locations/list");
        model.addAttribute("title","Locations");
        model.addAttribute("locationList",locationProvider.getAllLocations());
        return "listLocations";
    }
}
