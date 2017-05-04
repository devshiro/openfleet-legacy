package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class EmployeeService  implements EmployeeProvider{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee e) {
        employeeRepository.addEmployee(e);
    }
}
