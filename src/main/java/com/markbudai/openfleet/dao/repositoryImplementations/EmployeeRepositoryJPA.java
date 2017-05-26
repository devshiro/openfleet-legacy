package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.exception.NotFoundException;
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
public class EmployeeRepositoryJPA implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeRepositoryJPA(){
    }

    public EmployeeRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        Query query = entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    @Override
    public Employee getById(long id) {
        Employee e = entityManager.find(Employee.class,id);
        if(e==null) throw new NotFoundException(Employee.class);
        return e;
    }

    @Override
    public void add(Employee e){
        entityManager.persist(e);
    }

    @Override
    public void update(Employee e){
        entityManager.merge(e);
    }
}
