package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 07..
 */
@Service
public class TractorService implements TractorProvider {

    private static Logger logger = LoggerFactory.getLogger(TractorService.class);

    private TractorRepository tractorRepository;

    @Autowired
    public TractorService(TractorRepository repository){
        this.tractorRepository = repository;
        logger.debug("{} Service created.",TractorService.class);
    }

    @Override
    public List<Tractor> getAllTractors() {
        List<Tractor> tractorList = tractorRepository.getAllTractors();
        tractorList = tractorList.stream().filter(p->p.getDateOfSell() == null).collect(Collectors.toList());
        logger.debug("Serving {} tractors",tractorList.size());
        return tractorList;
    }

    @Override
    public Tractor getTractorById(long id) {
        Tractor tractor = tractorRepository.getTractorById(id);
        logger.debug("Serving tractor {}.",tractor);
        return tractor;
    }

    @Override
    public void addTractor(Tractor tractor) {
        logger.debug("Adding {} tractor.",tractor);
        tractorRepository.addTractor(tractor);
    }

    @Override
    public void updateTractor(Tractor tractor) {
        logger.debug("Updating tractor {}",tractor);
        tractorRepository.updateTractor(tractor);
    }

    @Override
    public void sellTractor(long id) {
        logger.debug("Selling tractor with id {}",id);
        Tractor t = tractorRepository.getTractorById(id);
        logger.debug("Found tractor {}",t);
        t.setDateOfSell(LocalDate.now());
        tractorRepository.updateTractor(t);
    }

    @Override
    public List<SupervisionDetails> getSupervisionList() {
        List<SupervisionDetails> supervisionDetails = new ArrayList<>();
        List<Tractor> tractorList = this.getAllTractors();
        for(Tractor tractor : tractorList){
            if(DateUtils.getDaysDifference(tractor.getDateOfSupervision(), LocalDate.now()) <= 30){
                SupervisionDetails details = new SupervisionDetails();
                details.setDate_of_supervision(tractor.getDateOfSupervision());
                details.setDays_remaining(DateUtils.getDaysDifference(tractor.getDateOfSupervision(),LocalDate.now()));
                details.setManufacturer(tractor.getManufacturer());
                details.setType(tractor.getType());
                details.setPlate_no(tractor.getPlateNumber());
                supervisionDetails.add(details);
            }
        }
        logger.debug("in 30 days of supervision: {}",supervisionDetails.size());
        return supervisionDetails;
    }
}
