package com.markbudai.openfleet.dao.repositories;

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
public class TransferCostRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public TransferCostRepository(){}

    public List<TransferCost> getAllCosts(){
        Query query = entityManager.createQuery("select c from transfercost c");
        return query.getResultList();
    }

    public TransferCost getCostById(long id){
        return entityManager.find(TransferCost.class,id);
    }

    public void addCost(TransferCost cost){
        entityManager.persist(cost);
    }

    public void updateCost(TransferCost cost){
        entityManager.merge(cost);
    }

    public void deleteCost(long id){
        TransferCost cost = getCostById(id);
        if(cost != null){
            entityManager.remove(cost);
        }
    }
}
