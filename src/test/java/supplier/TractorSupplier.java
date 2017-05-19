package supplier;

import com.markbudai.openfleet.model.Tractor;

import javax.transaction.Transactional;
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
        tractor.setMax_weight(1000);
        tractor.setFuel_norm(1.0);
        tractor.setChassis_number("SSSSSAMPLE");
        tractor.setPlate_number("SAM-PLE");
        tractor.setDate_of_manufacture(LocalDate.of(1999,01,01));
        tractor.setDate_of_acquire(LocalDate.of(2017,01,01));
        tractor.setDate_of_supervision(LocalDate.now().plusDays(7));
        return tractor;
    }
}
