package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.VehicleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mark on 2017. 04. 15..
 */
@Controller
public class VehicleController {

    @Autowired
    private VehicleProvider vehicleProvider;


    @RequestMapping("/vehicles/list")
    public String listVehicles(Model model){
        model.addAttribute("vehicleList",vehicleProvider.getAllVehicles());
        model.addAttribute("path","/vehicles/list");
        model.addAttribute("title","Vehicles");
        return "listVehicles";
    }
}
