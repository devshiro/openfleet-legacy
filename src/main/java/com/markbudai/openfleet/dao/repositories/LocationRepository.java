package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Location;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface LocationRepository {
    List<Location> getAllLocations();

    Location getLocationById(long id);

    void saveLocation(Location location);

    void updateLocation(Location location);

    void deleteLocation(long id);
}
