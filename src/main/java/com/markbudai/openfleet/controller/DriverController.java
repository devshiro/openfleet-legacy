package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.DriverProvider;
import com.markbudai.openfleet.model.Driver;
import com.markbudai.openfleet.pojo.SamplePieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/drivers/test", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Driver> testGet(@RequestParam("id") long id){
        return driverProvider.getAllDrivers();
    }
}
