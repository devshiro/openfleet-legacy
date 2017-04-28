package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.dao.providers.VehicleProvider;
import com.markbudai.openfleet.model.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class VehicleController {

    @Autowired
    private VehicleProvider vehicleProvider;
    @Autowired
    private TractorProvider tractorProvider;
    @Autowired
    private TrailerProvider trailerProvider;


    @RequestMapping("/vehicles/list")
    public String listVehicles(Model model){
        model.addAttribute("vehicleList",vehicleProvider.getAllVehicles());
        model.addAttribute("path","/vehicles/list");
        model.addAttribute("title","Vehicles");
        return "listVehicles";
    }

    @RequestMapping("/vehicle")
    public String vehicleDetail(@RequestParam("id") long id, Model model){
        model.addAttribute("path","/vehicles/list");
        model.addAttribute("title","Vehicles");
        model.addAttribute("tractorList",tractorProvider.getAllTractors());
        model.addAttribute("trailerList",trailerProvider.getAllTrailers());
        model.addAttribute("vehicle",vehicleProvider.getVehicleById(id));
        return "vehicleDetails";
    }
}
