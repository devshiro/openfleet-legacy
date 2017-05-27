package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Tractor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Class to persist {@link com.markbudai.openfleet.model.Tractor} objects using JPA.
 */
@Transactional
@Repository
public class TractorRepositoryJPA implements TractorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty costructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TractorRepositoryJPA} object.
     */
    public TractorRepositoryJPA(){
    }

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TractorRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.TractorRepositoryJPA} object.
     */
    public TractorRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Retrieves all stored {@link com.markbudai.openfleet.model.Tractor} objects from the database.
     * @return a {@link java.util.List} of all {@link com.markbudai.openfleet.model.Tractor} objects stored in the database.
     */
    @Override
    public List<Tractor> getAll() {
        Query query = entityManager.createQuery("select e from Tractor e");
        return query.getResultList();
    }

    /**
     * Retrieves the stored {@link com.markbudai.openfleet.model.Tractor} object from the database with given {@code id}.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Tractor} object.
     * @return the {@link com.markbudai.openfleet.model.Tractor} object with given {@code id} from the database.
     */
    @Override
    public Tractor getById(long id) {
        Tractor t = entityManager.find(Tractor.class,id);
        if(t == null) throw new NotFoundException(Tractor.class);
        return t;
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.Tractor} object in the database.
     * @param tractor the {@link com.markbudai.openfleet.model.Tractor} object to store in the database.
     */
    @Override
    public void add(Tractor tractor){
        entityManager.persist(tractor);
    }

    /**
     * Updates the stored version of the {@link com.markbudai.openfleet.model.Tractor} object in the database.
     * @param tractor the newer {@link com.markbudai.openfleet.model.Tractor} object for update.
     */
    @Override
    public void update(Tractor tractor){
        entityManager.merge(tractor);
    }
}