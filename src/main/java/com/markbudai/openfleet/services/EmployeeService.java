package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.exception.EmptyParameterException;
import com.markbudai.openfleet.exception.IdException;
import com.markbudai.openfleet.exception.IncorrectMethodParameterException;
import com.markbudai.openfleet.exception.NullException;
import com.markbudai.openfleet.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 03..
 */
@Service
public class EmployeeService  implements EmployeeProvider{

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
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
