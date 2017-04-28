package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.DriverProvider;
import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.VehicleProvider;
import com.markbudai.openfleet.model.Driver;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class DriverRepository implements DriverProvider {

    private List<Driver> driverList;

    @Autowired
    private EmployeeProvider employeeProvider;

    @Autowired
    private VehicleProvider vehicleProvider;

    public DriverRepository(){
        driverList = new ArrayList<>();
    }

    private void setUpRepository(){
        Vehicle v = vehicleProvider.getVehicleById(1);
        Employee e = employeeProvider.getEmployeeById(1);
        driverList.clear();
        driverList.add(new Driver(1,e,v));
    }



    @Override
    public List<Driver> getAllDrivers() {
        setUpRepository();
        return driverList;
    }

    @Override
    public Driver getDriverById(long id) {
        setUpRepository();
        return driverList.stream().filter(p->p.getDriverId() == id).collect(Collectors.toList()).get(0);
    }
}
