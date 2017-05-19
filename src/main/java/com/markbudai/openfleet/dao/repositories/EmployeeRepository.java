package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.exception.NoEmployeeFoundException;
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

    public EmployeeRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    public Employee getEmployeeById(long id) {
        Employee e = entityManager.find(Employee.class,id);
        if(e==null) throw new NoEmployeeFoundException(id);
        return e;
    }

    public void addEmployee(Employee e){
        entityManager.persist(e);
    }

    public void updateEmployee(Employee e){
        entityManager.merge(e);
    }
}
