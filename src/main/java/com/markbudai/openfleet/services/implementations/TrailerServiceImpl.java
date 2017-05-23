package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.framework.builder.TrailerBuilder;
import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import com.markbudai.openfleet.services.TrailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TrailerServiceImpl implements TrailerService {

    private static Logger logger = LoggerFactory.getLogger(TrailerServiceImpl.class);

    private TrailerRepository trailerRepository;

    @Autowired
    public TrailerServiceImpl(TrailerRepository repository){
        this.trailerRepository = repository;
        logger.info("{} Service created.", TrailerServiceImpl.class);
    }

    @Override
    public List<Trailer> getAllTrailers() {
        List<Trailer> trailerList = trailerRepository.getAllTrailers();
        trailerList = trailerList.stream().filter(p->p.getDateOfSell() == null).collect(Collectors.toList());
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
        t.setDateOfSell(LocalDate.now());
        trailerRepository.updateTrailer(t);
    }

    @Override
    public List<SupervisionDetails> getSupervisionList() {
        List<SupervisionDetails> supervisionDetails = new ArrayList<>();
        List<Trailer> trailerList = this.getAllTrailers();
        for(Trailer trailer : trailerList){
            if(DateUtils.getDaysDifference(trailer.getDateOfSupervision(), LocalDate.now()) <= 30){
                SupervisionDetails details = new SupervisionDetails();
                details.setDateOfSupervision(trailer.getDateOfSupervision());
                details.setDaysRemaining(DateUtils.getDaysDifference(trailer.getDateOfSupervision(),LocalDate.now()));
                details.setManufacturer(trailer.getManufacturer());
                details.setType(trailer.getType());
                details.setPlateNo(trailer.getPlateNumber());
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
