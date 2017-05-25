package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.model.Location;
import com.markbudai.openfleet.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository){
        this.locationRepository = repository;
    }

    @Override
    public List<Location> getAllLocations(){
        return locationRepository.getAllLocations();
    }

    @Override
    public Location getLocationById(long id) {
        return locationRepository.getLocationById(id);
    }

    @Override
    public void addLocation(Location location) {
        locationRepository.saveLocation(location);
    }

    @Override
    public void updateLocation(Location location){
        locationRepository.updateLocation(location);
    }

    @Override
    public void deleteLocation(long id) {
        locationRepository.deleteLocation(id);
    }
}