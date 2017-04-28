package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Driver;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface DriverProvider {
    List<Driver> getAllDrivers();
    Driver getDriverById(long id);
}
