package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Transactional
@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeRepository(){
    }

    private void setUpRepository(){
       // employeeList.add(new Employee(1,"John","Doe", LocalDate.of(1993,04,12),
       //         home,"000","Jane Doe","111","22222",home,LocalDate.of(2017,01,01),null));
    }

    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    public Employee getEmployeeById(long id) {
        return entityManager.find(Employee.class,id);
    }

    public void addEmployee(Employee e){
        entityManager.persist(e);
    }

    public void updateEmployee(Employee e){
        entityManager.merge(e);
    }
}
