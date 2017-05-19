package supplier;

import com.markbudai.openfleet.model.Trailer;

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
        trailer.setPlate_number("SAM-LPE");
        trailer.setDate_of_supervision(LocalDate.now().plusDays(7));
        return trailer;
    }
}
