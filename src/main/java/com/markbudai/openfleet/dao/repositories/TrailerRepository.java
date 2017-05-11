package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.model.Trailer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Transactional
@Repository
public class TrailerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    //private List<Trailer> trailerList;

    public TrailerRepository(){
        /*
        Trailer t3 = new Trailer(3,"Bodex","64t",LocalDate.of(2016,9,12),
                LocalDate.of(2017,03,03),LocalDate.of(2020,9,01),
                "HGF-707","CXG45700032A2F541",5635,64000);
        trailerList.add(t3);*/
    }

    public List<Trailer> getAllTrailers() {
        Query query = entityManager.createQuery("select t from Trailer t");
        return query.getResultList();
    }

    public Trailer getTrailerById(long id) {
        return entityManager.find(Trailer.class,id);
    }

    public void addTrailer(Trailer t){
        entityManager.persist(t);
    }

    public void updateTrailer(Trailer t){
        entityManager.merge(t);
    }
}
