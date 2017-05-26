package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.exception.EmptyParameterException;
import com.markbudai.openfleet.model.Tractor;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

/**
 * Class for mapping {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.Tractor}.
 */
public class TractorBuilder {

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.Tractor} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.Tractor} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.Tractor} object.
     * @exception com.markbudai.openfleet.exception.EmptyParameterException if any parameter is empty.
     */
    public static Tractor buildFromWebRequest(WebRequest request){
        Tractor tractor = new Tractor();
        if(!request.getParameter("id").isEmpty()){
            tractor.setId(Long.parseLong(request.getParameter("id")));
        }
        if(request.getParameter("type").isEmpty()){
            throw new EmptyParameterException("type");
        }
        tractor.setType(request.getParameter("type"));
        if(request.getParameter("manufacturer").isEmpty()){
            throw new EmptyParameterException("manufacturer");
        }
        tractor.setManufacturer(request.getParameter("manufacturer"));
        if(request.getParameter("date_of_manufacture").isEmpty()){
            throw new EmptyParameterException("date_of_manufacture");
        }
        tractor.setDateOfManufacture(LocalDate.parse(request.getParameter("date_of_manufacture")));
        if(request.getParameter("date_of_acquire").isEmpty()){
            throw new EmptyParameterException("date_of_acquire");
        }
        tractor.setDateOfAcquire(LocalDate.parse(request.getParameter("date_of_acquire")));
        if(request.getParameter("date_of_supervision").isEmpty()){
            throw new EmptyParameterException("date_of_supervision");
        }
        tractor.setDateOfSupervision(LocalDate.parse(request.getParameter("date_of_supervision")));
        if(request.getParameter("plate_number").isEmpty()){
            throw new EmptyParameterException("plate_number");
        }
        tractor.setPlateNumber(request.getParameter("plate_number"));
        if(request.getParameter("chassis_number").isEmpty()){
            throw new EmptyParameterException("chassis_number");
        }
        tractor.setChassisNumber(request.getParameter("chassis_number"));
        if(request.getParameter("fuel_norm").isEmpty()){
            throw new EmptyParameterException("fuel_norm");
        }
        tractor.setFuelNorm(Double.parseDouble(request.getParameter("fuel_norm")));
        if(request.getParameter("weight").isEmpty()){
            throw new EmptyParameterException("weight");
        }
        tractor.setWeight(Long.parseLong(request.getParameter("weight")));
        if(request.getParameter("max_weight").isEmpty()){
            throw new EmptyParameterException("max_weight");
        }
        tractor.setMaxWeight(Long.parseLong(request.getParameter("max_weight")));
        return tractor;
    }
}
