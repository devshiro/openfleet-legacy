package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import com.markbudai.openfleet.services.TractorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for providing interactions between the UI controller and the {@link com.markbudai.openfleet.dao.repositories.TractorRepository}.
 */
@Service
public class TractorServiceImpl implements TractorService {

    private static Logger logger = LoggerFactory.getLogger(TractorServiceImpl.class);

    private TractorRepository tractorRepository;

    /**
     * Constructor for creating {@link com.markbudai.openfleet.services.implementations.TractorServiceImpl} object.
     * Used for Dependency Injection.
     * @param repository the {@link com.markbudai.openfleet.dao.repositories.TractorRepository} used by this service.
     */
    @Autowired
    public TractorServiceImpl(TractorRepository repository){
        this.tractorRepository = repository;
        logger.trace("{} Service created.", TractorServiceImpl.class);
    }

    @Override
    public List<Tractor> getAllTractors() {
        List<Tractor> tractorList = tractorRepository.getAll();
        tractorList = tractorList.stream().filter(p->p.getDateOfSell() == null).collect(Collectors.toList());
        logger.debug("Serving {} tractors",tractorList.size());
        return tractorList;
    }

    @Override
    public Tractor getTractorById(long id) {
        Tractor tractor = tractorRepository.getById(id);
        logger.debug("Serving tractor {}.",tractor);
        return tractor;
    }

    @Override
    public void addTractor(Tractor tractor) {
        logger.debug("Adding {} tractor.",tractor);
        tractorRepository.add(tractor);
    }

    @Override
    public void updateTractor(Tractor tractor) {
        logger.debug("Updating tractor {}",tractor);
        tractorRepository.update(tractor);
    }

    @Override
    public void sellTractor(long id) {
        logger.debug("Selling tractor with id {}",id);
        Tractor t = tractorRepository.getById(id);
        logger.debug("Found tractor {}",t);
        t.setDateOfSell(LocalDate.now());
        tractorRepository.update(t);
    }

    @Override
    public List<SupervisionDetails> getSupervisionList() {
        List<SupervisionDetails> supervisionDetails = new ArrayList<>();
        List<Tractor> tractorList = this.getAllTractors();
        for(Tractor tractor : tractorList){
            if(DateUtils.getDaysDifference(tractor.getDateOfSupervision(), LocalDate.now()) <= 30){
                SupervisionDetails details = new SupervisionDetails();
                details.setDateOfSupervision(tractor.getDateOfSupervision());
                details.setDaysRemaining(DateUtils.getDaysDifference(tractor.getDateOfSupervision(),LocalDate.now()));
                details.setManufacturer(tractor.getManufacturer());
                details.setType(tractor.getType());
                details.setPlateNo(tractor.getPlateNumber());
                supervisionDetails.add(details);
            }
        }
        logger.debug("in 30 days of supervision: {}",supervisionDetails.size());
        return supervisionDetails;
    }
}
