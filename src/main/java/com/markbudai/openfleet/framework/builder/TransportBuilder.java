package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.services.EmployeeService;
import com.markbudai.openfleet.services.LocationService;
import com.markbudai.openfleet.services.TractorService;
import com.markbudai.openfleet.services.TrailerService;
import com.markbudai.openfleet.model.Transport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Created by Mark on 2017. 05. 09..
 */
@Component
public class TransportBuilder {

    private EmployeeService employeeService;
    private TractorService tractorService;
    private TrailerService trailerService;
    private LocationService locationService;

    private static Logger logger = LoggerFactory.getLogger(TransportBuilder.class);

    @Autowired
    public TransportBuilder(EmployeeService employeeService, TractorService tractorService, TrailerService trailerService,
                            LocationService locationService){
        this.employeeService = employeeService;
        this.tractorService = tractorService;
        this.trailerService = trailerService;
        this.locationService = locationService;
    }

    public Transport buildFromWebRequest(WebRequest request){
        Transport transport = new Transport();
        logger.debug("Trying to build Transport object from WebRequest");
        if(request.getParameter("id").isEmpty()){
            logger.debug("New transport will be built.");
        } else {
            transport.setId(Long.parseLong(request.getParameter("id")));
        }
        if(request.getParameter("tractor").isEmpty()){
            logger.debug("No tractor parameter is provided.");
            return null;
        } else {
            transport.setTractor(tractorService.getTractorById(Long.parseLong(request.getParameter("tractor"))));
        }

        if(request.getParameter("trailer").isEmpty()){
            logger.debug("No trailer parameter is provided.");
            return null;
        } else {
            transport.setTrailer(trailerService.getTrailerById(Long.parseLong(request.getParameter("trailer"))));
        }

        if(request.getParameter("employee").isEmpty()){
            logger.debug("No employee parameter is provided.");
            return null;
        } else {
            transport.setEmployee(employeeService.getEmployeeById(Long.parseLong(request.getParameter("employee"))));
        }

        if(request.getParameter("cargo_count").isEmpty()){
            logger.debug("No cargo count parameter is provided.");
            return null;
        } else {
            transport.setCargoCount(Long.parseLong(request.getParameter("cargo_count")));
        }

        if(request.getParameter("cargo_weight").isEmpty()){
            logger.debug("No cargo weight parameter is provided.");
            return null;
        } else {
            transport.setCargoWeight(Long.parseLong(request.getParameter("cargo_weight")));
        }

        if(request.getParameter("cargo_name").isEmpty()){
            logger.debug("No cargo name parameter is provided.");
            return null;
        } else {
            transport.setCargoName(request.getParameter("cargo_name"));
        }

        if(request.getParameter("place_of_load").isEmpty()){
            logger.debug("No load place parameter is provided.");
            return null;
        } else {
            transport.setPlaceOfLoad(locationService.getLocationById(Long.parseLong(request.getParameter("place_of_load"))));
        }

        if(request.getParameter("place_of_unload").isEmpty()){
            logger.debug("No unload place parameter is provided.");
            return null;
        } else {
            transport.setPlaceOfUnload(locationService.getLocationById(Long.parseLong(request.getParameter("place_of_unload"))));
        }

        if(request.getParameter("time_of_load").isEmpty()){
            logger.debug("No load timedate parameter is provided.");
            return null;
        } else {
            transport.setTimeOfLoad(LocalDateTime.parse(request.getParameter("time_of_load")));
        }
        if(request.getParameter("time_of_unload").isEmpty()){
            logger.debug("No unload timedate parameter is provided.");
            return null;
        } else {
            transport.setTimeOfUnload(LocalDateTime.parse(request.getParameter("time_of_unload")));
        }
        if(request.getParameter("start").isEmpty()){
            logger.debug("No start timedate parameter is provided.");
            return null;
        } else {
            transport.setStart(LocalDateTime.parse(request.getParameter("start")));
        }
        if(request.getParameter("finish").isEmpty()){
            logger.debug("No finish timedate parameter is provided.");
            return null;
        } else {
            transport.setFinish(LocalDateTime.parse(request.getParameter("finish")));
        }
        return transport;
    }
}
