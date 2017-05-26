package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.services.LocationService;
import com.markbudai.openfleet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

/**
 * Class for mapping {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.Employee}.
 */
@Component
public class EmployeeBuilder {

    private LocationService locationService;

    /**
     * Constructor for creating an {@link com.markbudai.openfleet.framework.builder.EmployeeBuilder} object.
     * @param locationService a {@link com.markbudai.openfleet.services.LocationService} object to manage {@link com.markbudai.openfleet.model.Location}s during the build process.
     */
    @Autowired
    public EmployeeBuilder(LocationService locationService){
        this.locationService = locationService;
    }

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.Employee} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.Employee} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.Employee} object.
     */
    public Employee buildFromWebRequest(WebRequest request){
        Employee e = new Employee();
        if(!request.getParameter("id").isEmpty()){
            e.setId(Long.parseLong(request.getParameter("id")));
        }
        e.setFirstName(request.getParameter("firstName"));
        e.setLastName(request.getParameter("lastName"));
        e.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        //get Location
        e.setPlaceOfBirth(locationService.getLocationById(Long.parseLong(request.getParameter("placeOfBirth"))));
        e.setSocialInsuranceNo(request.getParameter("socialInsuranceNo"));
        e.setTaxNo(request.getParameter("taxNo"));
        e.setMothersName(request.getParameter("mothersName"));
        e.setDriversCardNo(request.getParameter("driversCardNo"));
        e.setPlaceOfLiving(locationService.getLocationById(Long.parseLong(request.getParameter("placeOfLiving"))));
        e.setEmploymentDate(LocalDate.parse(request.getParameter("employmentDate")));
        return e;
    }
}
