package com.markbudai.openfleet.dao.repositories;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.model.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 28..
 */
@Repository
public class LocationRepository implements LocationProvider {

    @PersistenceContext
    private EntityManager entityManager;

    public LocationRepository(){
    }

    @Override
    public List<Location> getAllLocations() {
        Query query = entityManager.createQuery("select e from Location e");
        return query.getResultList();
    }

    @Override
    public Location getLocationById(long id) {
        return entityManager.find(Location.class,id);
    }
}
