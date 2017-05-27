package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Trailer;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Class to persist {@link com.markbudai.openfleet.model.Trailer} objects using JPA.
 */
@Transactional
@Repository
public class TrailerRepositoryJPA implements TrailerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TrailerRepositoryJPA} object.
     */
    public TrailerRepositoryJPA(){
    }

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TrailerRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.TrailerRepositoryJPA} object.
     */
    public TrailerRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Lists all stored {@link com.markbudai.openfleet.model.Trailer} objects.
     * @return a {@link java.util.List} containing all stored {@link com.markbudai.openfleet.model.Trailer} objects.
     */
    @Override
    public List<Trailer> getAll() {
        Query query = entityManager.createQuery("select t from Trailer t");
        return query.getResultList();
    }

    /**
     * Retrieves an {@link com.markbudai.openfleet.model.Trailer} object with given {@code id} from the database.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Trailer} object.
     * @return the {@link com.markbudai.openfleet.model.Trailer} object with the given {@code id}.
     */
    @Override
    public Trailer getById(long id) {
        Trailer t = entityManager.find(Trailer.class, id);
        if(t==null) throw new NotFoundException(Trailer.class);
        return t;
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.Trailer} object.
     * @param trailer the {@link com.markbudai.openfleet.model.Trailer} object to store.
     */
    @Override
    public void add(Trailer trailer){
        entityManager.persist(trailer);
    }

    /**
     * Updates the {@link com.markbudai.openfleet.model.Trailer} object in the database.
     * @param trailer the newer {@link com.markbudai.openfleet.model.Trailer} object.
     */
    @Override
    public void update(Trailer trailer){
        entityManager.merge(trailer);
    }
}
