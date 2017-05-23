package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.TransferCost;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface TransferCostRepository {
    List<TransferCost> getAllCosts();

    TransferCost getCostById(long id);

    void addCost(TransferCost cost);

    void updateCost(TransferCost cost);

    void deleteCost(long id);
}
