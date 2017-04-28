package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.dao.providers.VehicleProvider;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class VehicleRepository implements VehicleProvider {

    private List<Vehicle> vehicleList;

    @Autowired
    private TractorProvider tractorProvider;

    @Autowired
    private TrailerProvider trailerProvider;

    public VehicleRepository(){
        vehicleList = new ArrayList<>();
    }

    private void setUpRepository(){
        vehicleList.clear();
        Tractor t1 = tractorProvider.getTractorById(1);
        Trailer trailer = trailerProvider.getTrailerById(1);
        vehicleList.add(new Vehicle(1,t1,trailer));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        setUpRepository();
        return vehicleList;
    }

    @Override
    public Vehicle getVehicleById(long id) {
        setUpRepository();
        return vehicleList.stream().filter(p->p.getVehicleId() == id).collect(Collectors.toList()).get(0);
    }
}
