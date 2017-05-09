package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.model.Tractor;
import org.apache.tomcat.jni.Local;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 07..
 */
public class TractorBuilder {

    public static Tractor buildFromWebRequest(WebRequest request){
        Tractor tractor = new Tractor();
        if(!request.getParameter("id").isEmpty()){
            tractor.setId(Long.parseLong(request.getParameter("id")));
        }
        if(request.getParameter("type").isEmpty()){
            return null;
        }
        tractor.setType(request.getParameter("type"));
        if(request.getParameter("manufacturer").isEmpty()){
            return null;
        }
        tractor.setManufacturer(request.getParameter("manufacturer"));
        if(request.getParameter("date_of_manufacture").isEmpty()){
            return null;
        }
        tractor.setDate_of_manufacture(LocalDate.parse(request.getParameter("date_of_manufacture")));
        if(request.getParameter("date_of_acquire").isEmpty()){
            return null;
        }
        tractor.setDate_of_acquire(LocalDate.parse(request.getParameter("date_of_acquire")));
        if(request.getParameter("date_of_supervision").isEmpty()){
            return null;
        }
        tractor.setDate_of_supervision(LocalDate.parse(request.getParameter("date_of_supervision")));
        if(request.getParameter("plate_number").isEmpty()){
            return null;
        }
        tractor.setPlate_number(request.getParameter("plate_number"));
        if(request.getParameter("chassis_number").isEmpty()){
            return null;
        }
        tractor.setChassis_number(request.getParameter("chassis_number"));
        if(request.getParameter("fuel_norm").isEmpty()){
            return null;
        }
        tractor.setFuel_norm(Double.parseDouble(request.getParameter("fuel_norm")));
        if(request.getParameter("weight").isEmpty()){
            return null;
        }
        tractor.setWeight(Long.parseLong(request.getParameter("weight")));
        if(request.getParameter("max_weight").isEmpty()){
            return null;
        }
        tractor.setMax_weight(Long.parseLong(request.getParameter("max_weight")));
        return tractor;
    }
}
