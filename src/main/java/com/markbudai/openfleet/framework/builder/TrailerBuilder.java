package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.model.Trailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 09..
 */
public class TrailerBuilder {

    private static Logger logger = LoggerFactory.getLogger(TrailerBuilder.class);

    public static Trailer buildFromWebRequest(WebRequest request){
        logger.trace("Start buildig from Web Request");
        Trailer trailer = new Trailer();
        if(!request.getParameter("id").isEmpty()){
            trailer.setId(Long.parseLong(request.getParameter("id")));
            logger.trace("id..done");
        }
        if(request.getParameter("type").isEmpty()){
            return null;
        }
        trailer.setType(request.getParameter("type"));
        logger.trace("type..done");
        if(request.getParameter("manufacturer").isEmpty()){
            return null;
        }
        trailer.setManufacturer(request.getParameter("manufacturer"));
        logger.trace("manufacturer..done");
        if(request.getParameter("date_of_manufacture").isEmpty()){
            return null;
        }
        trailer.setDate_of_manufacture(LocalDate.parse(request.getParameter("date_of_manufacture")));
        logger.trace("date of manufacture..done");
        if(request.getParameter("date_of_acquire").isEmpty()){
            return null;
        }
        trailer.setDate_of_acquire(LocalDate.parse(request.getParameter("date_of_acquire")));
        logger.trace("date of acquire..done");
        if(request.getParameter("date_of_supervision").isEmpty()){
            return null;
        }
        trailer.setDate_of_supervision(LocalDate.parse(request.getParameter("date_of_supervision")));
        logger.trace("date of supervision..done");
        if(request.getParameter("plate_number").isEmpty()){
            return null;
        }
        trailer.setPlate_number(request.getParameter("plate_number"));
        logger.trace("plate number..done");
        if(request.getParameter("chassis_number").isEmpty()){
            return null;
        }
        trailer.setChassis_number(request.getParameter("chassis_number"));
        logger.trace("chassis number..done");
        if(request.getParameter("weight").isEmpty()){
            return null;
        }
        trailer.setWeight(Long.parseLong(request.getParameter("weight")));
        logger.trace("weight..done");
        if(request.getParameter("max_load_weight").isEmpty()){
            return null;
        }
        trailer.setMax_load_weight(Long.parseLong(request.getParameter("max_load_weight")));
        logger.trace("Done building!");
        return trailer;
    }
}
