package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Transport;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Transactional
@Repository
public class TransportRepositoryJPA implements TransportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TransportRepositoryJPA(){}

    public TransportRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Transport> getAll(){
        Query query = entityManager.createQuery("select t from Transport t");
        return query.getResultList();
    }

    @Override
    public void add(Transport t){
        entityManager.persist(t);
    }

    @Override
    public void update(Transport t){
        entityManager.merge(t);
    }

    @Override
    public Transport getById(long id){
        Transport t = entityManager.find(Transport.class, id);
        if(t == null) throw new NotFoundException(Transport.class);
        return t;
    }
}
