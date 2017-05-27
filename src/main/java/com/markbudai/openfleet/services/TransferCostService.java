package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.TransferCost;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface describing operations to manage {@link com.markbudai.openfleet.model.TransferCost} objects.
 */
public interface TransferCostService {

    /**
     * Retrives all {@link com.markbudai.openfleet.model.TransferCost} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.TransferCost} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     */
    List<TransferCost> getAllCosts();

    /**
     * Retrives all {@link com.markbudai.openfleet.model.TransferCost} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository} by date.
     * @param date a {@link java.time.LocalDate}.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.TransferCost} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository} by date.
     */
    List<TransferCost> getAllCostsByDate(LocalDate date);

    /**
     * Gets a {@link com.markbudai.openfleet.model.TransferCost} object with corresponding {@code id}.
     * @param id the {@code id} of the required {@link com.markbudai.openfleet.model.TransferCost} object.
     * @return the {@link com.markbudai.openfleet.model.TransferCost} object with corresponding {@code id}.
     */
    TransferCost getCostById(long id);

    /**
     * Passes a {@link com.markbudai.openfleet.model.TransferCost} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     * @param cost the {@link com.markbudai.openfleet.model.TransferCost} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     */
    void addCost(TransferCost cost);

    /**
     * Passes a {@link com.markbudai.openfleet.model.TransferCost} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     * @param cost the {@link com.markbudai.openfleet.model.TransferCost} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     */
    void updateCost(TransferCost cost);

    /**
     * Removes a {@link com.markbudai.openfleet.model.TransferCost} object with corresponding {@code id} from the {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} objects which needs to be removed.
     */
    void deleteCost(long id);
}
