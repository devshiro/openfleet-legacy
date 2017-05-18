package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.providers.TrailerProvider;
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

    private EmployeeProvider employeeProvider;
    private TractorProvider tractorProvider;
    private TrailerProvider trailerProvider;
    private LocationProvider locationProvider;

    private static Logger logger = LoggerFactory.getLogger(TransportBuilder.class);

    @Autowired
    public TransportBuilder(EmployeeProvider employeeProvider, TractorProvider tractorProvider, TrailerProvider trailerProvider,
                            LocationProvider locationProvider){
        this.employeeProvider = employeeProvider;
        this.tractorProvider = tractorProvider;
        this.trailerProvider = trailerProvider;
        this.locationProvider = locationProvider;
    }

    public Transport buildFromWebRequest(WebRequest request){
        Transport transport = new Transport();
        if(request.getParameter("tractor").isEmpty()){
            logger.debug("No tractor parameter is provided.");
            return null;
        } else {
            transport.setTractor(tractorProvider.getTractorById(Long.parseLong(request.getParameter("tractor"))));
        }

        if(request.getParameter("trailer").isEmpty()){
            logger.debug("No trailer parameter is provided.");
            return null;
        } else {
            transport.setTrailer(trailerProvider.getTrailerById(Long.parseLong(request.getParameter("trailer"))));
        }

        if(request.getParameter("employee").isEmpty()){
            logger.debug("No employee parameter is provided.");
            return null;
        } else {
            transport.setEmployee(employeeProvider.getEmployeeById(Long.parseLong(request.getParameter("employee"))));
        }

        if(request.getParameter("cargo_count").isEmpty()){
            logger.debug("No cargo count parameter is provided.");
            return null;
        } else {
            transport.setCargo_count(Long.parseLong(request.getParameter("cargo_count")));
        }

        if(request.getParameter("cargo_weight").isEmpty()){
            logger.debug("No cargo weight parameter is provided.");
            return null;
        } else {
            transport.setCargo_weight(Long.parseLong(request.getParameter("cargo_weight")));
        }

        if(request.getParameter("cargo_name").isEmpty()){
            logger.debug("No cargo name parameter is provided.");
            return null;
        } else {
            transport.setCargo_name(request.getParameter("cargo_name"));
        }

        if(request.getParameter("cargo_name").isEmpty()){
            logger.debug("No cargo name parameter is provided.");
            return null;
        } else {
            transport.setCargo_name(request.getParameter("cargo_name"));
        }

        if(request.getParameter("place_of_load").isEmpty()){
            logger.debug("No load place parameter is provided.");
            return null;
        } else {
            transport.setPlace_of_load(locationProvider.getLocationById(Long.parseLong(request.getParameter("place_of_load"))));
        }

        if(request.getParameter("place_of_unload").isEmpty()){
            logger.debug("No unload place parameter is provided.");
            return null;
        } else {
            transport.setPlace_of_unload(locationProvider.getLocationById(Long.parseLong(request.getParameter("place_of_unload"))));
        }

        if(request.getParameter("time_of_load").isEmpty()){
            logger.debug("No load timedate parameter is provided.");
            return null;
        } else {
            transport.setTime_of_load(LocalDateTime.parse(request.getParameter("time_of_load")));
        }
        if(request.getParameter("time_of_unload").isEmpty()){
            logger.debug("No unload timedate parameter is provided.");
            return null;
        } else {
            transport.setTime_of_unload(LocalDateTime.parse(request.getParameter("time_of_unload")));
        }
        return transport;
    }
}
