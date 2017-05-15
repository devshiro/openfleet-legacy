package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.framework.builder.LocationBuilder;
import com.markbudai.openfleet.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Controller
public class LocationController {

    private LocationProvider locationProvider;

    private static Logger logger = LoggerFactory.getLogger(LocationController.class);

    private static String viewPrefix = "location/";

    @Autowired
    public LocationController(LocationProvider provider){
        this.locationProvider = provider;
    }

    @RequestMapping("/locations/list")
    public String listLocations(Model model) {
        model.addAttribute("path","/locations/list");
        model.addAttribute("title","Locations");
        model.addAttribute("locationList",locationProvider.getAllLocations());
        return viewPrefix+"listLocations";
    }

    @RequestMapping("locations/new")
    public String newLocation(Model model){
        model.addAttribute("path","/locations/list");
        model.addAttribute("title","Locations");
        return viewPrefix+"locationDetails";
    }

    @PostMapping("location/add")
    public String saveLocation(Model model, WebRequest request){
        logger.trace("Adding new Location");
        Location loc = LocationBuilder.buildFromWebRequest(request);
        if(loc.getId() != 0){
            locationProvider.updateLocation(loc);
        } else {
            locationProvider.addLocation(loc);
        }
        return listLocations(model);
    }

    @RequestMapping("location/edit")
    public String editLocation(Model model, @RequestParam("id") long id){
        model.addAttribute("title","Locations");
        Location loc = locationProvider.getLocationById(id);
        model.addAttribute("location",loc);
        return viewPrefix+"locationDetails";
    }

    @RequestMapping("location/delete")
    public String deleteLocation(Model model, @RequestParam("id") long id){
        locationProvider.deleteLocation(id);
        return listLocations(model);
    }
}
