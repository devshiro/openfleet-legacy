package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.DriverProvider;
import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.dao.providers.VehicleProvider;
import com.markbudai.openfleet.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
public class TransportRepository implements TransportProvider {

    private List<Transport> transportList;

    @Autowired
    private VehicleProvider vehicleProvider;

    @Autowired
    private DriverProvider driverProvider;


    public TransportRepository(){
        transportList = new ArrayList<>();
    }

    private void setUpRepository(){
        transportList.clear();
    }


    @Override
    public List<Transport> getAllTransports() {
        return null;
    }
}
