package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.model.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Transactional
@Repository
public class LocationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public LocationRepository(){
    }

    public List<Location> getAllLocations() {
        Query query = entityManager.createQuery("select e from Location e");
        return query.getResultList();
    }

    public Location getLocationById(long id) {
        return entityManager.find(Location.class,id);
    }

    public void saveLocation(Location location){
        entityManager.persist(location);
    }

    public void updateLocation(Location location){
        entityManager.merge(location);
    }

    public void deleteLocation(long id){
        Location loc = entityManager.find(Location.class, id);
        if(loc != null){
            entityManager.remove(loc);
        }
    }
}
