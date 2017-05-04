package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class LocationService  implements LocationProvider{

    @Autowired
    private LocationRepository locationRepository;

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
}
