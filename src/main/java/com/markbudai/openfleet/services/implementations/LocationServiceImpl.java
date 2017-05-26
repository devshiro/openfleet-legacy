package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.model.Location;
import com.markbudai.openfleet.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class LocationServiceImpl implements LocationService {

    private Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository){
        this.locationRepository = repository;
        logger.trace("{} service created.",LocationServiceImpl.class);
    }

    @Override
    public List<Location> getAllLocations(){
        List<Location> locations = locationRepository.getAll();
        logger.trace("Serving {} locations.",locations.size());
        return locations;
    }

    @Override
    public Location getLocationById(long id) {
        Location location = locationRepository.getById(id);
        logger.trace("Serving location {} with id {}",location,id);
        return location;
    }

    @Override
    public void addLocation(Location location) {
        locationRepository.add(location);
        logger.trace("Added location {}",location);
    }

    @Override
    public void updateLocation(Location location){
        locationRepository.update(location);
        logger.trace("Location {} updated.",location);
    }

    @Override
    public void deleteLocation(long id) {
        locationRepository.deleteLocation(id);
        logger.trace("Location deleted identified by id {}",id);
    }
}
