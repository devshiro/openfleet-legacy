package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Location;

import java.util.List;

/**
 * Interface providing operations to manage {@link com.markbudai.openfleet.model.Location} objects.
 */
public interface LocationService {
    /**
     * Retrieves all {@link com.markbudai.openfleet.model.Location} objects from a {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.Location} objects.
     */
    List<Location> getAllLocations();

    /**
     * Gets a {@link com.markbudai.openfleet.model.Location} object with corresponding {@code id}.
     * @param id the {@code id} of the required {@link com.markbudai.openfleet.model.Location} object.
     * @return the {@link com.markbudai.openfleet.model.Location} object with corresponding {@code id}.
     */
    Location getLocationById(long id);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Location} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     * @param location the {@link com.markbudai.openfleet.model.Location} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for storage.
     */
    void addLocation(Location location);

    /**
     * Passes a {@link com.markbudai.openfleet.model.Location} object to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     * @param location the {@link com.markbudai.openfleet.model.Location} object passed to the {@link com.markbudai.openfleet.dao.repositories.Repository} for update.
     */
    void updateLocation(Location location);

    /**
     * Removes a {@link com.markbudai.openfleet.model.Location} object with corresponding {@code id} from the {@link com.markbudai.openfleet.dao.repositories.Repository}.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Location} objects which needs to be removed.
     */
    void deleteLocation(long id);
}
