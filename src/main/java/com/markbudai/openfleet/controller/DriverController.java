package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.dao.providers.DriverProvider;
import com.markbudai.openfleet.model.Driver;
import com.markbudai.openfleet.pojo.SamplePieData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(DriverController.class);

    private DriverProvider driverProvider;

    @Autowired
    public DriverController(DriverProvider provider){
        this.driverProvider = provider;
        logger.debug("{} created.",this.getClass());
    }

    @RequestMapping("/drivers/list")
    public String listDrivers(Model model){
        logger.debug("Serving /drivers/list");
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