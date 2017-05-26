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
 * This class represents a view controller which processes /api uri requests.
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

    /**
     * Empty constructor for creating ApiController objects.
     */
    public ApiController(){}

    /**
     * Sets the TractorService for the ApiController object.
     * Used for Dependency Injection.
     * @param tractorService the TractorService object.
     */
    @Autowired
    public void setTractorService(TractorService tractorService){
        this.tractorService = tractorService;
    }

    /**
     * Sets the TrailerService for the ApiController object.
     * Used for Dependency Injection.
     * @param trailerService the TrailerService object.
     */
    @Autowired
    public void setTrailerService(TrailerService trailerService){
        this.trailerService = trailerService;
    }

    /**
     * Sets the EmployeeService for the ApiController object.
     * Used for Dependency Injection.
     * @param employeeService the EmployeeService object.
     */
    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    /**
     * Sets the LocationService for the ApiController object.
     * Used for Dependency Injection.
     * @param locationService the LocationService object.
     */
    @Autowired
    public void setLocationService(LocationService locationService){
        this.locationService = locationService;
    }

    /**
     * Sets the TransportService for the ApiController object.
     * Used for Dependency Injection.
     * @param transportService the TransportService object.
     */
    @Autowired
    public void setTransportService(TransportService transportService){
        this.transportService = transportService;
    }

    /**
     * Sets the PaymentService for the ApiController object.
     * Used for Dependency Injection.
     * @param paymentService the PaymentService object.
     */
    @Autowired
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    /**
     * Returns a list of all Tractor objects stored in the database.
     * Maps to /api/tractors.
     * @return a list of all Tractor ojbects from the database in JSON format.
     */
    @RequestMapping(value = "/tractors", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Tractor> tractors(){
        return tractorService.getAllTractors();
    }

    /**
     * Returns a Badge object containing information about the stored objects in the database.
     * Maps to /api/badges.
     * @return a Badge object in JSON format.
     */
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

    /**
     * Returns a list of all Trailer objects strored in the database.
     * Maps to /api/trailers.
     * @return a list of all Trailer objects from the database in JSON format.
     */
    @RequestMapping(value = "/trailers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Trailer> trailers(){
        return trailerService.getAllTrailers();
    }

    /**
     * Returns a list of all Employee objects stored in the database.
     * Maps to /api/employees.
     * @return a list of all Employee objects from the database in JSON format.
     */
    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Employee> employees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Returns a list of all Location objects stored in the database.
     * Maps to /api/locations.
     * @return a list of all Location objects from the database in JSON format.
     */
    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Location> allLocations(){
        List<Location> locations = locationService.getAllLocations();
        return locations;
    }

    /**
     * Returns a List of Pairs containing an employee's name and a Pair of the current months worked and rest days.
     * The list contains only the employees whom have any finished transports in this month.
     * Maps to /api/employeePerformance.
     * @return a List of Pairs containing an employee's name and a Pair of the current month's worked and rest days.
     */
    @RequestMapping(value = "/employeePerformance", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<Pair<String,Pair<Double,Double>>> getDriversPerformance(){
        return paymentService.getDriversPerformance(LocalDate.now().getYear(), LocalDate.now().getMonth().getValue());
    }

}
