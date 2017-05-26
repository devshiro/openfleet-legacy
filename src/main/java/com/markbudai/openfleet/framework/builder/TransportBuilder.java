package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.exception.EmptyParameterException;
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
 * Class for mapping {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.Tractor}.
 */
@Component
public class TransportBuilder {

    private EmployeeService employeeService;
    private TractorService tractorService;
    private TrailerService trailerService;
    private LocationService locationService;

    private static Logger logger = LoggerFactory.getLogger(TransportBuilder.class);

    /**
     * Constructor for creating new {@link com.markbudai.openfleet.framework.builder.TransportBuilder} object.
     * @param employeeService the {@link com.markbudai.openfleet.services.EmployeeService} object to manage {@link com.markbudai.openfleet.model.Employee} during the build process.
     * @param tractorService the {@link com.markbudai.openfleet.services.TractorService} object to manage {@link com.markbudai.openfleet.model.Tractor} during the build process.
     * @param trailerService the {@link com.markbudai.openfleet.services.TrailerService} object to manage {@link com.markbudai.openfleet.model.Trailer} during the build process.
     * @param locationService the {@link com.markbudai.openfleet.services.LocationService} object to manage {@link com.markbudai.openfleet.model.Location} during the build process.
     */
    @Autowired
    public TransportBuilder(EmployeeService employeeService, TractorService tractorService, TrailerService trailerService,
                            LocationService locationService){
        this.employeeService = employeeService;
        this.tractorService = tractorService;
        this.trailerService = trailerService;
        this.locationService = locationService;
    }

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.Transport} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.Transport} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.Transport} object.
     * @exception com.markbudai.openfleet.exception.EmptyParameterException if any parameter is empty.
     */
    public Transport buildFromWebRequest(WebRequest request){
        Transport transport = new Transport();
        logger.debug("Trying to build Transport object from WebRequest");
        if(request.getParameter("id") == null){
            logger.debug("New transport will be built.");
        } else {
            transport.setId(Long.parseLong(request.getParameter("id")));
        }
        if(request.getParameter("tractor").isEmpty()){
            logger.debug("No tractor parameter is provided.");
            throw new EmptyParameterException("tractor");
        } else {
            transport.setTractor(tractorService.getTractorById(Long.parseLong(request.getParameter("tractor"))));
        }

        if(request.getParameter("trailer").isEmpty()){
            logger.debug("No trailer parameter is provided.");
            throw new EmptyParameterException("trailer");
        } else {
            transport.setTrailer(trailerService.getTrailerById(Long.parseLong(request.getParameter("trailer"))));
        }

        if(request.getParameter("employee").isEmpty()){
            logger.debug("No employee parameter is provided.");
            throw new EmptyParameterException("employee");
        } else {
            transport.setEmployee(employeeService.getEmployeeById(Long.parseLong(request.getParameter("employee"))));
        }

        if(request.getParameter("cargo_count").isEmpty()){
            logger.debug("No cargo count parameter is provided.");
            throw new EmptyParameterException("cargo_count");
        } else {
            transport.setCargoCount(Long.parseLong(request.getParameter("cargo_count")));
        }

        if(request.getParameter("cargo_weight").isEmpty()){
            logger.debug("No cargo weight parameter is provided.");
            throw new EmptyParameterException("cargo_weight");
        } else {
            transport.setCargoWeight(Long.parseLong(request.getParameter("cargo_weight")));
        }

        if(request.getParameter("cargo_name").isEmpty()){
            logger.debug("No cargo name parameter is provided.");
            throw new EmptyParameterException("cargo_name");
        } else {
            transport.setCargoName(request.getParameter("cargo_name"));
        }

        if(request.getParameter("place_of_load").isEmpty()){
            logger.debug("No load place parameter is provided.");
            throw new EmptyParameterException("place_of_load");
        } else {
            transport.setPlaceOfLoad(locationService.getLocationById(Long.parseLong(request.getParameter("place_of_load"))));
        }

        if(request.getParameter("place_of_unload").isEmpty()){
            logger.debug("No unload place parameter is provided.");
            throw new EmptyParameterException("place_of_unload");
        } else {
            transport.setPlaceOfUnload(locationService.getLocationById(Long.parseLong(request.getParameter("place_of_unload"))));
        }

        if(request.getParameter("time_of_load").isEmpty()){
            logger.debug("No load timedate parameter is provided.");
            throw new EmptyParameterException("time_of_load");
        } else {
            transport.setTimeOfLoad(LocalDateTime.parse(request.getParameter("time_of_load")));
        }
        if(request.getParameter("time_of_unload").isEmpty()){
            logger.debug("No unload timedate parameter is provided.");
            throw new EmptyParameterException("time_of_unload");
        } else {
            transport.setTimeOfUnload(LocalDateTime.parse(request.getParameter("time_of_unload")));
        }
        if(request.getParameter("start").isEmpty()){
            logger.debug("No start timedate parameter is provided.");
            throw new EmptyParameterException("start");
        } else {
            transport.setStart(LocalDateTime.parse(request.getParameter("start")));
        }
        if(request.getParameter("finish").isEmpty()){
            logger.debug("No finish timedate parameter is provided.");
            throw new EmptyParameterException("finish");
        } else {
            transport.setFinish(LocalDateTime.parse(request.getParameter("finish")));
        }
        return transport;
    }
}
