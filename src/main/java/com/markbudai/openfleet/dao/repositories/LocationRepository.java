package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Location;

import java.util.List;

/**
 * Interface describing DAO operations for managing Location objects.
 */
public interface LocationRepository extends Repository<Location>{
    /**
     * Delete Location object with given id.
     * @param id the id of the deleted Location object.
     */
    void deleteLocation(long id);
}
