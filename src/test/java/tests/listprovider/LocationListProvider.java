package tests.listprovider;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 26..
 */
public class LocationListProvider implements LocationRepository {
    private List<Location> storage;

    public void preload(List<Location> locations){
        storage.addAll(locations);
    }

    public LocationListProvider(){
        storage = new ArrayList<>();
    }

    @Override
    public void add(Location location) {
        storage.add(location);
    }

    @Override
    public void deleteLocation(long id) {
        storage.remove(getById(id));
    }

    @Override
    public void update(Location location) {
        deleteLocation(location.getId());
        storage.add(location);
    }

    @Override
    public Location getById(long id) {
        for(Location l : storage){
            if(l.getId() == id){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Location> getAll() {
        return storage;
    }
}
