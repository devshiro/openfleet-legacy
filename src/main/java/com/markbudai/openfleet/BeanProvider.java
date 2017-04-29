package com.markbudai.openfleet;

import com.markbudai.openfleet.dao.providers.*;
import com.markbudai.openfleet.dao.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Configuration
public class BeanProvider {

    @Bean
    public LocationProvider locationProvider(){
        return new LocationRepository();
    }

    @Bean
    public TractorProvider tractorProvider(){
        return new TractorRepository();
    }

    @Bean
    public EmployeeProvider employeeProvider(){
        return new EmployeeRepository();
    }

    @Bean
    public TrailerProvider trailerProvider(){
        return new TrailerRepository();
    }

    @Bean
    public VehicleProvider vehicleProvider(){
        return new VehicleRepository();
    }

    @Bean
    public DriverProvider driverProvider(){
        return new DriverRepository();
    }
}