package com.markbudai.openfleet.controller;

import com.markbudai.openfleet.model.*;
import com.markbudai.openfleet.pojo.Badge;
import com.markbudai.openfleet.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    private static Logger logger = LoggerFactory.getLogger(ApiController.class);

    private TractorService tractorService;
    private TrailerService trailerService;
    private EmployeeService employeeService;
    private LocationService locationService;
    private TransportService transportService;
    private PaymentService paymentService;

    public ApiController(){}

    @Autowired
    public void setTractorService(TractorService tractorService){
        this.tractorService = tractorService;
    }

    @Autowired
    public void setTrailerService(TrailerService trailerService){
        this.trailerService = trailerService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Autowired
    public void setLocationService(LocationService locationService){
        this.locationService = locationService;
    }

    @Autowired
    public void setTransportService(TransportService transportService){
        this.transportService = transportService;
    }

    @Autowired
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/tractors", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Tractor> tractors(){
        return tractorService.getAllTractors();
    }

    @RequestMapping(value = "/badges", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Badge badge(){
        Badge badges = new Badge();
        badges.setLocation_count(this.allLocations().size());
        badges.setEmployee_count(this.employees().size());
        badges.setTrailer_count(this.trailers().size());
        badges.setTractor_count(this.tractors().size());
        badges.setJob_count(this.transportService.getAllTransports().size());
        return badges;
    }

    @RequestMapping(value = "/trailers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Trailer> trailers(){
        return trailerService.getAllTrailers();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Employee> employees(){
        return employeeService.getAllEmployees();
    }


    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Location> allLocations(){
        List<Location> locations = locationService.getAllLocations();
        return locations;
    }

    @RequestMapping(value = "/employeePerformance", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<Pair<String,Pair<Double,Double>>> getDriversPerformance(){
        return paymentService.getDriversPerformance(LocalDate.now().getYear(), LocalDate.now().getMonth().getValue());
    }

}
