package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.exception.EmptyParameterException;
import com.markbudai.openfleet.model.Trailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDate;

/**
 * Class for mapping {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.Trailer}.
 */
public class TrailerBuilder {

    private static Logger logger = LoggerFactory.getLogger(TrailerBuilder.class);

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.Trailer} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.Trailer} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.Trailer} object.
     * @exception com.markbudai.openfleet.exception.EmptyParameterException if any parameter is empty.
     */
    public static Trailer buildFromWebRequest(WebRequest request){
        logger.trace("Start buildig from Web Request");
        Trailer trailer = new Trailer();
        if(!request.getParameter("id").isEmpty()){
            trailer.setId(Long.parseLong(request.getParameter("id")));
            logger.trace("id..done");
        }
        if(request.getParameter("type").isEmpty()){
            throw new EmptyParameterException("type");
        }
        trailer.setType(request.getParameter("type"));
        logger.trace("type..done");
        if(request.getParameter("manufacturer").isEmpty()){
            throw new EmptyParameterException("manufacturer");
        }
        trailer.setManufacturer(request.getParameter("manufacturer"));
        logger.trace("manufacturer..done");
        if(request.getParameter("date_of_manufacture").isEmpty()){
            throw new EmptyParameterException("date_of_manufacture");
        }
        trailer.setDateOfManufacture(LocalDate.parse(request.getParameter("date_of_manufacture")));
        logger.trace("date of manufacture..done");
        if(request.getParameter("date_of_acquire").isEmpty()){
            throw new EmptyParameterException("date_of_acquire");
        }
        trailer.setDateOfAcquire(LocalDate.parse(request.getParameter("date_of_acquire")));
        logger.trace("date of acquire..done");
        if(request.getParameter("date_of_supervision").isEmpty()){
            throw new EmptyParameterException("date_of_supervision");
        }
        trailer.setDateOfSupervision(LocalDate.parse(request.getParameter("date_of_supervision")));
        logger.trace("date of supervision..done");
        if(request.getParameter("plate_number").isEmpty()){
            throw new EmptyParameterException("plate_umber");
        }
        trailer.setPlateNumber(request.getParameter("plate_number"));
        logger.trace("plate number..done");
        if(request.getParameter("chassis_number").isEmpty()){
            throw new EmptyParameterException("chassis_number");
        }
        trailer.setChassisNumber(request.getParameter("chassis_number"));
        logger.trace("chassis number..done");
        if(request.getParameter("weight").isEmpty()){
            throw new EmptyParameterException("weight");
        }
        trailer.setWeight(Long.parseLong(request.getParameter("weight")));
        logger.trace("weight..done");
        if(request.getParameter("max_load_weight").isEmpty()){
            throw new EmptyParameterException("max_load_weight");
        }
        trailer.setMaxLoadWeight(Long.parseLong(request.getParameter("max_load_weight")));
        logger.trace("Done building!");
        return trailer;
    }
}
