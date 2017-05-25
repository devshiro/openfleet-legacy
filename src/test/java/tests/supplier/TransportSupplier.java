package tests.supplier;

import com.markbudai.openfleet.services.TransportService;
import com.markbudai.openfleet.model.Transport;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Month month = LocalDate.now().getMonth();
        transport.setCargoWeight(1);
        transport.setCargoName("Sample Cargo");
        transport.setId(1);
        transport.setCargoCount(1);
        transport.setStart(LocalDateTime.of(2017,month.getValue(),1,1,0));
        transport.setFinish(LocalDateTime.of(2017,month.getValue(),10,10,10));
        transport.setTimeOfLoad(LocalDateTime.of(2017,month.getValue(),1,8,0));
        transport.setTimeOfUnload(LocalDateTime.of(2017,month.getValue(),10,8,0));
        transport.setStart(LocalDateTime.of(2017,month.getValue(),1,8,0));
        transport.setFinish(LocalDateTime.of(2017,month.getValue(),10,8,0));
        transport.setPlaceOfLoad(LocationSupplier.getSampleLocation());
        transport.setPlaceOfUnload(LocationSupplier.getSampleLocation());
        transport.setEmployee(EmployeeSupplier.getSampleEmployee());
        transport.setTractor(TractorSupplier.getSampleTractor());
        transport.setTrailer(TrailerSupplier.getSampleTrailer());
        return transport;
    }

    public static Transport getAnotherMonthsSampleTransport(){
        Transport transport = new Transport();
        transport.setCargoWeight(10);
        transport.setCargoName("Sample Cargo II");
        transport.setId(2);
        transport.setCargoCount(2);
        transport.setStart(LocalDateTime.of(2017,4,1,1,0));
        transport.setFinish(LocalDateTime.of(2017,4,10,10,10));
        transport.setTimeOfLoad(LocalDateTime.of(2017,4,1,8,0));
        transport.setTimeOfUnload(LocalDateTime.of(2017,4,10,8,0));
        transport.setStart(LocalDateTime.of(2017,4,1,8,0));
        transport.setFinish(LocalDateTime.of(2017,4,10,8,0));
        transport.setPlaceOfLoad(LocationSupplier.getSampleLocation());
        transport.setPlaceOfUnload(LocationSupplier.getSampleLocation());
        transport.setEmployee(EmployeeSupplier.getSampleEmployee());
        transport.setTractor(TractorSupplier.getSampleTractor());
        transport.setTrailer(TrailerSupplier.getSampleTrailer());
        return transport;
    }

    public static TransportService getMockProvider(){
        TransportService transportService = Mockito.mock(TransportService.class);
        Mockito.when(transportService.getTransportById(1)).thenReturn(getSampleTransport());
        Mockito.when(transportService.getTransportByEmployee(EmployeeSupplier.getSampleEmployee())).thenReturn(getSampleTransportList());
        return transportService;
    }

    public static List<Transport> getSampleTransportList(){
        List<Transport> list = new ArrayList<>();
        list.add(getSampleTransport());
        list.add(getAnotherMonthsSampleTransport());
        return list;
    }

    public static List<Transport> getDateList(){
        Transport t1 = new Transport();
        t1.setStart(LocalDateTime.of(2016,12,28,12,0));
        t1.setFinish(LocalDateTime.of(2017,1,8,11,0));
        Transport t2 = new Transport();
        t2.setStart(LocalDateTime.of(2017,1,8,12,0));
        t2.setFinish(LocalDateTime.of(2017,1,17,11,0));
        Transport t3 = new Transport();
        t3.setStart(LocalDateTime.of(2017,1,16,12,0));
        t3.setFinish(LocalDateTime.of(2017,1,24,11,0));
        Transport t4 = new Transport();
        t4.setStart(LocalDateTime.of(2017,2,1,12,1));
        t4.setFinish(LocalDateTime.of(2017,2,4,11,2));

        return Arrays.asList(t3,t1,t2,t4);
    }

    public static List<Transport> getTransportsOnSameDay(){
        Transport t1 = new Transport();
        t1.setStart(LocalDateTime.of(2017,1,8,8,0));
        t1.setFinish(LocalDateTime.of(2017,1,8,9,0));
        Transport t2 = new Transport();
        t2.setStart(LocalDateTime.of(2017,1,8,10,0));
        t2.setFinish(LocalDateTime.of(2017,1,8,11,0));
        Transport t3 = new Transport();
        t3.setStart(LocalDateTime.of(2017,1,8,12,0));
        t3.setFinish(LocalDateTime.of(2017,1,8,13,0));
        Transport t4 = new Transport();
        t4.setStart(LocalDateTime.of(2017,1,8,14,1));
        t4.setFinish(LocalDateTime.of(2017,1,8,16,2));

        return Arrays.asList(t3,t1,t2,t4);
    }
}
