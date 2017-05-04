package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.framework.LocationBuilder;
import com.markbudai.openfleet.model.Location;
import com.markbudai.openfleet.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

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

    @RequestMapping("locations/new")
    public String newLocation(Model model){
        model.addAttribute("path","/locations/list");
        model.addAttribute("title","Locations");
        return "locationDetails";
    }

    @PostMapping("location/add")
    public String saveLocation(Model model, WebRequest request){
        Location loc = LocationBuilder.buildFromWebRequest(request);
        locationProvider.addLocation(loc);
        return listLocations(model);
    }
}
