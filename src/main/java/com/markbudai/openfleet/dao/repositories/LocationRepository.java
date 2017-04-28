package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class LocationRepository implements LocationProvider {

    private List<Location> locationList;

    public LocationRepository(){
        locationList = new ArrayList<>();
        Location l = new Location(1,"Hungary","SzSzBM","Nyíregyháza","Bodrogi","19","4551");
        locationList.add(l);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationList;
    }

    @Override
    public Location getLocationById(long id) {
        return locationList.stream().filter(p->p.getId() == id).collect(Collectors.toList()).get(0);
    }
}
