package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Tractor;
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
public class TractorRepositoryJPA implements TractorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TractorRepositoryJPA(){
    }

    public TractorRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Tractor> getAllTractors() {
        Query query = entityManager.createQuery("select e from Tractor e");
        return query.getResultList();
    }

    @Override
    public Tractor getTractorById(long id) {
        Tractor t = entityManager.find(Tractor.class,id);
        if(t == null) throw new NotFoundException(Tractor.class);
        return t;
    }

    @Override
    public void addTractor(Tractor t){
        entityManager.persist(t);
    }

    @Override
    public void updateTractor(Tractor t){
        entityManager.merge(t);
    }
}