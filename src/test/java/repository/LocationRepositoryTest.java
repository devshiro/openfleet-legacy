package repository;

import com.markbudai.openfleet.dao.repositories.LocationRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Location;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class LocationRepositoryTest {
    private static LocationRepository locationRepository;
    private static EntityManager mockedEntityManager;

    @BeforeClass
    public static void setup(){
        mockedEntityManager = Mockito.mock(EntityManager.class);
        Mockito.when(mockedEntityManager.find(Location.class,99)).thenReturn(null);
        locationRepository = new LocationRepository(mockedEntityManager);
    }

    @Test(expected = NotFoundException.class)
    public void assertError(){
        locationRepository.getLocationById(99);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNonExistingLocation(){
        locationRepository.deleteLocation(99);
    }
}
