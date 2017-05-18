package supplier;

import com.markbudai.openfleet.model.Location;
import com.markbudai.openfleet.model.Transport;

import java.time.LocalDateTime;

/**
 * Class supplying sample Transport objects for testing purposes.
 */
public class TransportSupplier {
    /**
     * Function which creates a sample Transport object for testing.
     * @return the sample Transport object for testing.
     */
    public static Transport getSampleTransport(){
        Transport transport = new Transport();
        transport.setCargo_weight(1);
        transport.setCargo_name("Sample Cargo");
        transport.setId(1);
        transport.setCargo_count(1);
        transport.setStart(LocalDateTime.of(2017,5,1,1,0));
        transport.setFinish(LocalDateTime.of(2017,5,10,10,10));
        transport.setTime_of_load(LocalDateTime.of(2017,5,1,8,0));
        transport.setTime_of_unload(LocalDateTime.of(2017,5,10,8,0));
        transport.setPlace_of_load(LocationSupplier.getSampleLocation());
        transport.setPlace_of_unload(LocationSupplier.getSampleLocation());
        transport.setEmployee(EmployeeSupplier.getSampleEmployee());
        transport.setTractor(TractorSupplier.getSampleTractor());
        transport.setTrailer(TrailerSupplier.getSampleTrailer());
        return transport;
    }
}
