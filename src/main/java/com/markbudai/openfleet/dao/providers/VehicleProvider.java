package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Vehicle;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface VehicleProvider {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(long id);
}
