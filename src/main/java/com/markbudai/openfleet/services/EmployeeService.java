package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;

import java.util.List;

/**
 * Interface describing operations required to manage {@link com.markbudai.openfleet.model.Employee} objects.
 */
public interface EmployeeService {
    /**
     * Lists all employee objects from the database.
     * @return list of Employee objects stored in the database.
     */
    List<Employee> getAllEmployees();

    /**
     * Gets the Employee object identified by the id.
     * @param id the id of the Employee object.
     * @return the Employee object identified by the id.
     */
    Employee getEmployeeById(long id);

    /**
     * Stores an Employee object in the database.
     * @param e the Employee object.
     */
    void addEmployee(Employee e);

    /**
     * Updates an Employee object in the database.
     * @param e the Employee object.
     */
    void updateEmployee(Employee e);

    /**
     * Logical delete of an Employee object.
     * @param id the id of the Employee object which needs to be logically deleted.
     */
    void fireEmployee(long id);
}
