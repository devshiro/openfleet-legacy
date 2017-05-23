package tests.supplier;

import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.model.Trailer;
import org.mockito.Mockito;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class TrailerSupplier {
    public static Trailer getSampleTrailer(){
        Trailer trailer = new Trailer();
        trailer.setId(1);
        trailer.setManufacturer("Sample Co");
        trailer.setType("Samplerunner");
        trailer.setPlateNumber("SAM-LPE");
        trailer.setDateOfManufacture(LocalDate.of(1999,01,01));
        trailer.setDateOfAcquire(LocalDate.of(2017,01,01));
        trailer.setChassisNumber("SSSAMPLE");
        trailer.setWeight(1);
        trailer.setMaxLoadWeight(100);
        trailer.setDateOfSupervision(LocalDate.now().plusDays(7));
        return trailer;
    }

    public static TrailerProvider getMockProvider(){
        TrailerProvider trailerProvider = Mockito.mock(TrailerProvider.class);
        Mockito.when(trailerProvider.getTrailerById(1)).thenReturn(getSampleTrailer());
        return trailerProvider;
    }
}
