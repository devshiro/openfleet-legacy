package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Location;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface LocationProvider {
    List<Location> getAllLocations();
    Location getLocationById(long id);
    void addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(long id);
}
