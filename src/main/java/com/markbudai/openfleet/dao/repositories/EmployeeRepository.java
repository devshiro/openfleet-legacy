package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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
