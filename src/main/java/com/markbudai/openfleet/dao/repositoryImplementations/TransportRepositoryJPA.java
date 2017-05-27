package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Transport;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Class to persist Transport objects using JPA.
 */
@Transactional
@Repository
public class TransportRepositoryJPA implements TransportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TransportRepositoryJPA} object.
     */
    public TransportRepositoryJPA(){}

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TransportRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.TransportRepositoryJPA} object.
     */
    public TransportRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Lists all stored {@link com.markbudai.openfleet.model.Transport} objects.
     * @return a {@link java.util.List} containing all stored {@link com.markbudai.openfleet.model.Transport} objects.
     */
    @Override
    public List<Transport> getAll(){
        Query query = entityManager.createQuery("select t from Transport t");
        return query.getResultList();
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.Transport} object.
     * @param transport the {@link com.markbudai.openfleet.model.Transport} object to store.
     */
    @Override
    public void add(Transport transport){
        entityManager.persist(transport);
    }

    /**
     * Updates the {@link com.markbudai.openfleet.model.Transport} object in the database.
     * @param transport the newer {@link com.markbudai.openfleet.model.Transport} object.
     */
    @Override
    public void update(Transport transport){
        entityManager.merge(transport);
    }

    /**
     * Retrieves an {@link com.markbudai.openfleet.model.Transport} object with given {@code id} from the database.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Transport} object.
     * @return the {@link com.markbudai.openfleet.model.Transport} object with the given {@code id}.
     */
    @Override
    public Transport getById(long id){
        Transport t = entityManager.find(Transport.class, id);
        if(t == null) throw new NotFoundException(Transport.class);
        return t;
    }
}
