package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;

import java.util.List;

/**
 * Interface describing operations required to manage {@link com.markbudai.openfleet.model.Employee} objects.
 */
public interface EmployeeService {
    /**
     * Lists all {@link com.markbudai.openfleet.model.Employee} objects from the database.
     * <p>Note: The fired employees will not show in this list.</p>
     * @return list of {@link com.markbudai.openfleet.model.Employee} objects stored in the database.
     */
    List<Employee> getAllEmployees();

    /**
     * Gets the {@link com.markbudai.openfleet.model.Employee} object identified by the id.
     * @param id the id of the Employee object.
     * @return the {@link com.markbudai.openfleet.model.Employee} object identified by the id.
     */
    Employee getEmployeeById(long id);

    /**
     * Stores an {@link com.markbudai.openfleet.model.Employee} object in the database.
     * @param e the {@link com.markbudai.openfleet.model.Employee} object.
     */
    void addEmployee(Employee e);

    /**
     * Updates an {@link com.markbudai.openfleet.model.Employee} object in the database.
     * @param e the {@link com.markbudai.openfleet.model.Employee} object.
     */
    void updateEmployee(Employee e);

    /**
     * Logical delete of an {@link com.markbudai.openfleet.model.Employee} object.
     * @param id the id of the {@link com.markbudai.openfleet.model.Employee} object which needs to be logically deleted.
     */
    void fireEmployee(long id);

    /**
     * Lists all {@link com.markbudai.openfleet.model.Employee} objects from the database including the fired employees as well.
     * @return {@link java.util.List} of all {@link com.markbudai.openfleet.model.Employee} objects from the database.
     */
    List<Employee> listAllStoredEmployees();
}
