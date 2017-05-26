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
 * Class to persist {@link com.markbudai.openfleet.model.Location} objects using JPA.
 */
@Transactional
@Repository
public class LocationRepositoryJPA implements LocationRepository {

    private Logger logger = LoggerFactory.getLogger(LocationRepositoryJPA.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty costructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.LocationRepositoryJPA} object.
     */
    public LocationRepositoryJPA(){
    }

    /**
     * Constructor for creating {@link com.markbudai.openfleet.dao.repositoryImplementations.LocationRepositoryJPA} objects with premade {@link javax.persistence.EntityManager}.
     * Used for testing purposes.
     * @param entityManager the {@link javax.persistence.EntityManager} to be used by the {@link com.markbudai.openfleet.dao.repositoryImplementations.LocationRepositoryJPA} object.
     */
    public LocationRepositoryJPA(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Stores the {@link com.markbudai.openfleet.model.Location} object in the database.
     * @param location the {@link com.markbudai.openfleet.model.Location} object to store.
     */
    @Override
    public void add(Location location) {
        entityManager.persist(location);
    }

    /**
     * Updates the {@link com.markbudai.openfleet.model.Location} object in the database.
     * @param location the newer {@link com.markbudai.openfleet.model.Location} object.
     */
    @Override
    public void update(Location location) {
        entityManager.merge(location);
    }

    /**
     * Retrieves the {@link com.markbudai.openfleet.model.Location} object with given {@code id} from the database.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Location} object.
     * @return the {@link com.markbudai.openfleet.model.Location} object from the database with given {@code id}.
     */
    @Override
    public Location getById(long id) {
        logger.debug("Id: {}",id);
        Location location = entityManager.find(Location.class,id);
        logger.debug("location: {}",location);
        if(location == null) throw new NotFoundException(Location.class);
        return location;
    }

    /**
     * Retrieves all stored {@link com.markbudai.openfleet.model.Location} objects from the database.
     * @return a {@link java.util.List} of all stored {@link com.markbudai.openfleet.model.Location} objects from the database.
     */
    @Override
    public List<Location> getAll() {
        Query query = entityManager.createQuery("select e from Location e");
        return query.getResultList();
    }

    /**
     * Removes a {@link com.markbudai.openfleet.model.Location} object from the database.
     * @param id the {@code id} of the deleted {@link com.markbudai.openfleet.model.Location} object.
     */
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