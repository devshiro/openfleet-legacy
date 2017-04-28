package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
public class EmployeeRepository implements EmployeeProvider {

    @Autowired
    private LocationProvider locationProvider;

    private List<Employee> employeeList;

    public EmployeeRepository(){
        employeeList = new ArrayList<>();
    }

    private void setUpRepository(){
        employeeList.clear();
        Location home = locationProvider.getLocationById(1);
        employeeList.add(new Employee(1,"John","Doe", LocalDate.of(1993,04,12),
                home,"000","Jane Doe","111","22222",home));
    }

    @Override
    public List<Employee> getAllEmployees() {
        setUpRepository();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(long id) {
        setUpRepository();
        return employeeList.stream().filter(p->p.getId() == id).collect(Collectors.toList()).get(0);
    }
}
