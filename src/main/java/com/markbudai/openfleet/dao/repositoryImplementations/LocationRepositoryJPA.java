package com.markbudai.openfleet.dao.repositoryImplementations;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class LocationRepositoryJPA implements LocationRepository {

    private Logger logger = LoggerFactory.getLogger(LocationRepositoryJPA.class);

    @PersistenceContext
    private EntityManager entityManager;

    public LocationRepositoryJPA(){
    }

    public LocationRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public void add(Location location) {
        entityManager.persist(location);
    }

    @Override
    public void update(Location location) {
        entityManager.merge(location);
    }

    @Override
    public Location getById(long id) {
        logger.debug("Id: {}",id);
        Location location = entityManager.find(Location.class,id);
        logger.debug("location: {}",location);
        if(location == null) throw new NotFoundException(Location.class);
        return location;
    }

    @Override
    public List<Location> getAll() {
        Query query = entityManager.createQuery("select e from Location e");
        return query.getResultList();
    }

    @Override
    public void deleteLocation(long id){
        Location loc = entityManager.find(Location.class, id);
        if(loc != null){
            entityManager.remove(loc);
        } else {
            throw new NotFoundException(Location.class);
        }
    }
}