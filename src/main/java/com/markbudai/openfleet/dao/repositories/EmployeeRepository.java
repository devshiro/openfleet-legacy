package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Employee;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 23..
 */
public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void addEmployee(Employee e);

    void updateEmployee(Employee e);
}
