package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.services.LocationService;
import com.markbudai.openfleet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 04..
 */
@Component
public class EmployeeBuilder {

    private LocationService locationService;

    @Autowired
    public EmployeeBuilder(LocationService locationService){
        this.locationService = locationService;
    }


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
