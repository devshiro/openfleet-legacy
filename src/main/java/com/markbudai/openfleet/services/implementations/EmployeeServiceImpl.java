package com.markbudai.openfleet.services.implementations;

import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.employeeRepository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.getAllEmployees().stream()
               .filter(p->p.getEndOfEmploymentDate()==null)
               .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee e = employeeRepository.getEmployeeById(id);
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee e) {
        employeeRepository.addEmployee(e);
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeRepository.updateEmployee(e);
    }

    @Override
    public void fireEmployee(long id) {
        Employee e = employeeRepository.getEmployeeById(id);
        e.setEndOfEmploymentDate(LocalDate.now());
        employeeRepository.updateEmployee(e);
    }
}
