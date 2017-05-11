package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.TransferCostProvider;
import com.markbudai.openfleet.dao.repositories.TransferCostRepository;
import com.markbudai.openfleet.model.TransferCost;
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
public class TransferCostService implements TransferCostProvider {

    private TransferCostRepository costRepository;

    @Autowired
    public TransferCostService(TransferCostRepository repository){
        this.costRepository = repository;
    }

    @Override
    public List<TransferCost> getAllCosts() {
        return costRepository.getAllCosts();
    }

    @Override
    public List<TransferCost> getAllCostsByDate(LocalDate date) {
        return costRepository.getAllCosts().stream()
                .filter(p->p.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public TransferCost getCostById(long id) {
        return costRepository.getCostById(id);
    }

    @Override
    public void addCost(TransferCost cost) {
        costRepository.addCost(cost);
    }

    @Override
    public void updateCost(TransferCost cost) {
        costRepository.updateCost(cost);
    }

    @Override
    public void deleteCost(long id) {
        costRepository.deleteCost(id);
    }
}
