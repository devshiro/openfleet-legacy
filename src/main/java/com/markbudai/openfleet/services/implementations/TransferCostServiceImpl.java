package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.TransferCostRepository;
import com.markbudai.openfleet.model.TransferCost;
import com.markbudai.openfleet.services.TransferCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for providing interactions between the UI controller and the {@link com.markbudai.openfleet.dao.repositories.TransferCostRepository}.
 */
@Service
public class TransferCostServiceImpl implements TransferCostService {

    private TransferCostRepository costRepository;

    /**
     * Constructor for creating {@link com.markbudai.openfleet.services.implementations.TransferCostServiceImpl} object.
     * Used for Dependency Injection.
     * @param repository the {@link com.markbudai.openfleet.dao.repositories.TransferCostRepository} used by this service.
     */
    @Autowired
    public TransferCostServiceImpl(TransferCostRepository repository){
        this.costRepository = repository;
    }

    @Override
    public List<TransferCost> getAllCosts() {
        return costRepository.getAll();
    }

    @Override
    public List<TransferCost> getAllCostsByDate(LocalDate date) {
        return costRepository.getAll().stream()
                .filter(p->p.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public TransferCost getCostById(long id) {
        return costRepository.getById(id);
    }

    @Override
    public void addCost(TransferCost cost) {
        costRepository.add(cost);
    }

    @Override
    public void updateCost(TransferCost cost) {
        costRepository.update(cost);
    }

    @Override
    public void deleteCost(long id) {
        costRepository.deleteCost(id);
    }
}
