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
 * Created by Mark on 2017. 04. 28..
 */
@Transactional
@Repository
public class TrailerRepositoryJPA implements TrailerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //private List<Trailer> trailerList;

    public TrailerRepositoryJPA(){
    }

    public TrailerRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Trailer> getAllTrailers() {
        Query query = entityManager.createQuery("select t from Trailer t");
        return query.getResultList();
    }

    @Override
    public Trailer getTrailerById(long id) {
        Trailer t = entityManager.find(Trailer.class, id);
        if(t==null) throw new NotFoundException(Trailer.class);
        return t;
    }

    @Override
    public void addTrailer(Trailer t){
        entityManager.persist(t);
    }

    @Override
    public void updateTrailer(Trailer t){
        entityManager.merge(t);
    }
}
