package com.markbudai.openfleet.dao;

import com.markbudai.openfleet.model.Location;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mark on 2017. 03. 24..
 */
public interface LocationDAO {
    public Optional<Location> getLocationById(long id);
    public List<Location> getAllLocations();
    public Optional<List<Location>> getAllLocationsByCity(String city);
}
