package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.DriverProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Controller
public class DriverController {

    @Autowired
    private DriverProvider driverProvider;

    @RequestMapping("/drivers/list")
    public String listDrivers(Model model){
        model.addAttribute("path","/drivers/list");
        model.addAttribute("title","Drivers");
        model.addAttribute("driverList",driverProvider.getAllDrivers());
        return "listDrivers";
    }
}
