package com.markbudai.openfleet.dao.providers;

import com.markbudai.openfleet.model.Employee;

import java.util.List;

/**
 * Created by Mark on 2017. 04. 28..
 */
public interface EmployeeProvider {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    void addEmployee(Employee e);
    void updateEmployee(Employee e);

    void fireEmployee(long id);
}
