package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TransferCostRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.TransferCost;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 09..
 */
@Transactional
@Repository
public class TransferCostRepositoryJPA implements TransferCostRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public TransferCostRepositoryJPA(){}

    public TransferCostRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<TransferCost> getAllCosts(){
        Query query = entityManager.createQuery("select c from transfercost c");
        return query.getResultList();
    }

    @Override
    public TransferCost getCostById(long id){
        TransferCost cost = entityManager.find(TransferCost.class,id);
        if(cost == null) throw new NotFoundException(TransferCost.class);
        return cost;
    }

    @Override
    public void addCost(TransferCost cost){
        entityManager.persist(cost);
    }

    @Override
    public void updateCost(TransferCost cost){
        entityManager.merge(cost);
    }

    @Override
    public void deleteCost(long id){
        TransferCost cost = getCostById(id);
        if(cost != null){
            entityManager.remove(cost);
        }
    }
}