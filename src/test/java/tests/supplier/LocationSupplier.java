package tests.supplier;

import com.markbudai.openfleet.services.LocationService;
import com.markbudai.openfleet.model.Location;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class LocationSupplier {
    public static Location getSampleLocation(){
        Location loc = new Location();
        loc.setZipcode("4400");
        loc.setHouseNo("12");
        loc.setStreet("Sample strt");
        loc.setRegion("Sample Region");
        loc.setCity("Sample City");
        loc.setCountry("Sample Country");
        loc.setId(1);
        return loc;
    }

    public static List<Location> getSampleLocationList(){
        List<Location> list = new ArrayList<>();
        list.add(getSampleLocation());
        return list;
    }

    public static LocationService getMockProvider(){
        LocationService locationService = Mockito.mock(LocationService.class);
        Mockito.when(locationService.getLocationById(1)).thenReturn(getSampleLocation());
        return locationService;
    }
}
