package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;

import java.util.List;

/**
 * Interface describing operations to manage {@link com.markbudai.openfleet.model.Tractor} objects.
 */
public interface TractorService {

    /**
     * Retrieves all {@link com.markbudai.openfleet.model.Tractor} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * <p>Note: the sold tractors will not show up in this list.</p>
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.Tractor} objects.
     */
    List<Tractor> getAllTractors();

    /**
     * Gets a {@link com.markbudai.openfleet.model.Tractor} object with corresponding {@code id}.
     * @param id the {@code id} of the required {@link com.markbudai.openfleet.model.Tractor} object.
     * @return the {@link com.markbudai.openfleet.model.Tractor} object with corresponding {@code id}.
     */
    Tractor getTractorById(long id);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Tractor} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     * @param tractor the {@link com.markbudai.openfleet.model.Tractor} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     */
    void addTractor(Tractor tractor);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Tractor} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     * @param tractor the {@link com.markbudai.openfleet.model.Tractor} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     */
    void updateTractor(Tractor tractor);

    /**
     * Sets the {@link com.markbudai.openfleet.model.Tractor} object with corresponding {@code id} as sold.
     * The sell date will be today.
     * @param id of the {@link com.markbudai.openfleet.model.Tractor} object which needs to be sold.
     */
    void sellTractor(long id);

    /**
     * Creates a {@link java.util.List} of {@link com.markbudai.openfleet.pojo.SupervisionDetails} about the stored {@link com.markbudai.openfleet.model.Tractor}s.
     * A given tractor will be on the list if the next supervision is due in 30 days.
     * @return the {@link java.util.List} of {@link com.markbudai.openfleet.pojo.SupervisionDetails} about the stored {@link com.markbudai.openfleet.model.Tractor}s.
     */
    List<SupervisionDetails> getSupervisionList();
}
