package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Trailer;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class to persist Trailer objects using JPA.
 */
@Transactional
@Repository
public class TrailerRepositoryJPA implements TrailerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TrailerRepositoryJPA(){
    }

    public TrailerRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Trailer> getAll() {
        Query query = entityManager.createQuery("select t from Trailer t");
        return query.getResultList();
    }

    @Override
    public Trailer getById(long id) {
        Trailer t = entityManager.find(Trailer.class, id);
        if(t==null) throw new NotFoundException(Trailer.class);
        return t;
    }

    @Override
    public void add(Trailer t){
        entityManager.persist(t);
    }

    @Override
    public void update(Trailer t){
        entityManager.merge(t);
    }
}
