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
 * Class to persist {@link com.markbudai.openfleet.model.Employee} objects using JPA.
 */
@Transactional
@Repository
public class EmployeeRepositoryJPA implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.EmployeeRepositoryJPA} objects.
     */
    public EmployeeRepositoryJPA(){
    }

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.EmployeeRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.EmployeeRepositoryJPA} object.
     */
    public EmployeeRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Lists all stored {@link com.markbudai.openfleet.model.Employee} objects.
     * @return a {@link java.util.List} containing all stored {@link com.markbudai.openfleet.model.Employee} objects.
     */
    @Override
    public List<Employee> getAll() {
        Query query = entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    /**
     * Retrieves an {@link com.markbudai.openfleet.model.Employee} object with given {@code id} from the database.
     * @param id the {@code id} of the Employee object.
     * @return the {@link com.markbudai.openfleet.model.Employee} object with the given {@code id}.
     */
    @Override
    public Employee getById(long id) {
        Employee e = entityManager.find(Employee.class,id);
        if(e==null) throw new NotFoundException(Employee.class);
        return e;
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.Employee} object.
     * @param employee the {@link com.markbudai.openfleet.model.Employee} object to store.
     */
    @Override
    public void add(Employee employee){
        entityManager.persist(employee);
    }

    /**
     * Updates the {@link com.markbudai.openfleet.model.Employee} object in the database.
     * @param employee the newer {@link com.markbudai.openfleet.model.Employee} object.
     */
    @Override
    public void update(Employee employee){
        entityManager.merge(employee);
    }
}
