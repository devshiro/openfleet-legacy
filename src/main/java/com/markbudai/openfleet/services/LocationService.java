package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Transactional
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        return locationRepository.getAllLocations();
    }
}
