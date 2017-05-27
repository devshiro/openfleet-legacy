package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TransferCostRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.TransferCost;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Class to persist {@link com.markbudai.openfleet.dao.repositoryImplementations.TransferCostRepositoryJPA} objects using JPA.
 */
@Transactional
@Repository
public class TransferCostRepositoryJPA implements TransferCostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TransferCostRepositoryJPA} object.
     */
    public TransferCostRepositoryJPA(){}

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.TransferCostRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.TransferCostRepositoryJPA} object.
     */
    public TransferCostRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Lists all stored {@link com.markbudai.openfleet.model.TransferCost} objects.
     * @return a {@link java.util.List} containing all stored {@link com.markbudai.openfleet.model.TransferCost} objects.
     */
    @Override
    public List<TransferCost> getAll(){
        Query query = entityManager.createQuery("select c from transfercost c");
        return query.getResultList();
    }

    /**
     * Retrieves an {@link com.markbudai.openfleet.model.TransferCost} object with given {@code id} from the database.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} object.
     * @return the {@link com.markbudai.openfleet.model.TransferCost} object with the given {@code id}.
     */
    @Override
    public TransferCost getById(long id){
        TransferCost cost = entityManager.find(TransferCost.class,id);
        if(cost == null) throw new NotFoundException(TransferCost.class);
        return cost;
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.TransferCost} object.
     * @param cost the {@link com.markbudai.openfleet.model.TransferCost} object to store.
     */
    @Override
    public void add(TransferCost cost){
        entityManager.persist(cost);
    }

    /**
     * Updates the {@link com.markbudai.openfleet.model.TransferCost} object in the database.
     * @param cost the newer {@link com.markbudai.openfleet.model.TransferCost} object.
     */
    @Override
    public void update(TransferCost cost){
        entityManager.merge(cost);
    }

    /**
     * Removes the {@link com.markbudai.openfleet.model.TransferCost} object from the database with given {@code id}.
     * @param id the id of the deleted {@link com.markbudai.openfleet.model.TransferCost} object.
     */
    @Override
    public void deleteCost(long id){
        TransferCost cost = getById(id);
        if(cost != null){
            entityManager.remove(cost);
        }
    }
}
