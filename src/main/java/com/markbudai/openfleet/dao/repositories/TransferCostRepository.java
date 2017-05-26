package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.TransferCost;

import java.util.List;

/**
 * Interface describing DAO operations for managing TransferCost objects.
 */
public interface TransferCostRepository extends Repository<TransferCost>{
    /**
     * Delete TransferCost object with given id.
     * @param id the id of the deleted TransferCost object.
     */
    void deleteCost(long id);
}
