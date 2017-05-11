package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.model.Trailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 09..
 */
@Service
@Component
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
}
