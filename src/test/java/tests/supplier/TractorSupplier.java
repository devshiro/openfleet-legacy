package tests.supplier;

import com.markbudai.openfleet.services.TractorService;
import com.markbudai.openfleet.model.Tractor;
import org.mockito.Mockito;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class TractorSupplier {
    public static Tractor getSampleTractor(){
        Tractor tractor = new Tractor();
        tractor.setId(1);
        tractor.setManufacturer("Sample");
        tractor.setType("SampleV8");
        tractor.setWeight(1);
        tractor.setMaxWeight(1000);
        tractor.setFuelNorm(1.0);
        tractor.setChassisNumber("SSSSSAMPLE");
        tractor.setPlateNumber("SAM-PLE");
        tractor.setDateOfManufacture(LocalDate.of(1999,01,01));
        tractor.setDateOfAcquire(LocalDate.of(2017,01,01));
        tractor.setDateOfSupervision(LocalDate.now().plusDays(7));
        return tractor;
    }

    public static TractorService getMockProvider(){
        TractorService tractorService = Mockito.mock(TractorService.class);
        Mockito.when(tractorService.getTractorById(1)).thenReturn(getSampleTractor());
        return tractorService;
    }
}
