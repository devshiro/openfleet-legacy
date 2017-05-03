package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.services.LocationService;
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
    private LocationService locationService;

    @RequestMapping("/locations/list")
    public String listLocations(Model model) {
        model.addAttribute("path","/locations/list");
        model.addAttribute("title","Locations");
        model.addAttribute("locationList",locationService.getAllLocations());
        return "listLocations";
    }
}
