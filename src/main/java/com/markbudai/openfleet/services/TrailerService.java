package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.framework.builder.TrailerBuilder;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 09..
 */
@Service
public class TrailerService implements TrailerProvider {

    private static Logger logger = LoggerFactory.getLogger(TrailerService.class);

    private TrailerRepository trailerRepository;

    @Autowired
    public TrailerService(TrailerRepository repository){
        this.trailerRepository = repository;
        logger.info("{} Service created.",TrailerService.class);
    }

    @Override
    public List<Trailer> getAllTrailers() {
        List<Trailer> trailerList = trailerRepository.getAllTrailers();
        trailerList = trailerList.stream().filter(p->p.getDate_of_sell() == null).collect(Collectors.toList());
        logger.debug("Serving {} trailers",trailerList.size());
        return trailerList;
    }

    @Override
    public Trailer getTrailerById(long id) {
        Trailer t = trailerRepository.getTrailerById(id);
        logger.debug("Found: {} trailer",t);
        return t;
    }

    @Override
    public void addTrailer(Trailer trailer) {
        logger.trace("Adding.. {}",trailer);
        trailerRepository.addTrailer(trailer);
    }

    @Override
    public void updateTrailer(Trailer trailer) {
        logger.trace("Updating.. {}",trailer);
        trailerRepository.updateTrailer(trailer);
    }

    @Override
    public void sellTrailer(long id) {
        logger.trace("Selling trailer with id.. {}",id);
        Trailer t = getTrailerById(id);
        logger.debug("Trailer found for selling: {}",t);
        if(t!=null){
            t.setDate_of_sell(LocalDate.now());
            trailerRepository.updateTrailer(t);
        } else {
            logger.warn("Incorrect id {}. No sellable trailer found!",id);
        }

    }

    @Override
    public List<SupervisionDetails> getSupervisionList() {
        List<SupervisionDetails> supervisionDetails = new ArrayList<>();
        List<Trailer> trailerList = this.getAllTrailers();
        for(Trailer trailer : trailerList){
            if(DateUtils.getDaysDifference(trailer.getDate_of_supervision(), LocalDate.now()) <= 30){
                SupervisionDetails details = new SupervisionDetails();
                details.setDate_of_supervision(trailer.getDate_of_supervision());
                details.setDays_remaining(DateUtils.getDaysDifference(trailer.getDate_of_supervision(),LocalDate.now()));
                details.setManufacturer(trailer.getManufacturer());
                details.setType(trailer.getType());
                details.setPlate_no(trailer.getPlate_number());
                supervisionDetails.add(details);
            }
        }
        logger.debug("in 30 days of supervision: {}",supervisionDetails.size());
        return supervisionDetails;
    }

    @Override
    public void addOrUpdate(WebRequest request) {
        if(request.getParameter("id").isEmpty()){
            Trailer t = TrailerBuilder.buildFromWebRequest(request);
            logger.debug("Built: {}",t);
            this.addTrailer(t);
        } else {
            Trailer t = TrailerBuilder.buildFromWebRequest(request);
            this.updateTrailer(t);
        }
    }
}
