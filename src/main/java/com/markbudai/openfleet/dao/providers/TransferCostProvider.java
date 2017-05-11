package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.TransferCost;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 09..
 */
public interface TransferCostProvider {
    List<TransferCost> getAllCosts();
    List<TransferCost> getAllCostsByDate(LocalDate date);
    TransferCost getCostById(long id);
    void addCost(TransferCost cost);
    void updateCost(TransferCost cost);
    void deleteCost(long id);
}
