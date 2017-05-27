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
 * Service class for providing interactions between the UI controller and the {@link com.markbudai.openfleet.dao.repositories.EmployeeRepository}.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    /**
     * Constructor for creating {@link com.markbudai.openfleet.services.implementations.EmployeeServiceImpl} objects.
     * Used for Dependency Injection.
     * @param repository the {@link com.markbudai.openfleet.dao.repositories.EmployeeRepository} the service uses.
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.employeeRepository = repository;
        logger.trace("{} service created.",EmployeeServiceImpl.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.getAll().stream()
                .filter(p->p.getEndOfEmploymentDate()==null)
                .collect(Collectors.toList());
        logger.trace("Serving {} employees.",employees.size());
       return employees;
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee e = employeeRepository.getById(id);
        logger.trace("Serving employee {} with id {}.",e,id);
        return e;
    }

    @Override
    public void addEmployee(Employee e) {
        employeeRepository.add(e);
        logger.trace("Added employee {}.",e);
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeRepository.update(e);
        logger.trace("Employee {} updated.",e);
    }

    @Override
    public void fireEmployee(long id) {
        Employee e = employeeRepository.getById(id);
        e.setEndOfEmploymentDate(LocalDate.now());
        employeeRepository.update(e);
        logger.trace("Employee {} was fired today.",e);
    }
}
