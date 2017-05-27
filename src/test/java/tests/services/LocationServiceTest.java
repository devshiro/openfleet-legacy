package tests.services;

import com.markbudai.openfleet.model.Location;
import com.markbudai.openfleet.services.LocationService;
import com.markbudai.openfleet.services.implementations.LocationServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.listprovider.LocationListProvider;
import tests.supplier.LocationSupplier;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 26..
 */
public class LocationServiceTest {
    private static LocationService locationService;


    @BeforeClass
    public static void init() {
        LocationListProvider provider = new LocationListProvider();
        provider.preload(LocationSupplier.getSampleLocationList());
        locationService = new LocationServiceImpl(provider);
    }


    @Test
    public void testAddIncreaseSize(){
        int size = locationService.getAllLocations().size();
        locationService.addLocation(LocationSupplier.getSampleLocation());
        Assert.assertEquals(size+1,locationService.getAllLocations().size());
    }

    @Test
    public void testUpdateLocation(){
        Location location = LocationSupplier.getUniqueLocation();
        locationService.addLocation(location);
        location = LocationSupplier.getUniqueLocation();
        location.setCity("SampleNewSample");
        Location stored = locationService.getLocationById(99);
        Assert.assertNotNull(stored);
        Assert.assertNotEquals(location, stored);
        locationService.updateLocation(location);
        Assert.assertEquals("SampleNewSample",locationService.getLocationById(99).getCity());
    }

    @Test
    public void testDeleteLocation(){
        Location location = LocationSupplier.getUniqueLocation();
        location.setId(999);
        locationService.addLocation(location);
        locationService.deleteLocation(999);
        Assert.assertNull(locationService.getLocationById(999));
    }
}