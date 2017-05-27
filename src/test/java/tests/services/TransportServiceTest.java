package tests.services;

import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.services.TransportService;
import com.markbudai.openfleet.services.implementations.TransportServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import tests.supplier.EmployeeSupplier;
import tests.supplier.TransportSupplier;

/**
 * Created by Mark on 2017. 05. 26..
 */
public class TransportServiceTest {

    private static TransportService service;
    private static TransportRepository mockedTransportRepository;

    @BeforeClass
    public static void init(){
        mockedTransportRepository = TransportSupplier.getMockedRepository();
        service = new TransportServiceImpl(mockedTransportRepository);
    }

    @Test
    public void testTransportSize(){
        Assert.assertEquals(2,service.getAllTransports().size());
    }

    @Test
    public void testTransportSizeByEmployee(){
        Assert.assertEquals(2,service.getTransportByEmployee(EmployeeSupplier.getSampleEmployee()).size());
    }
}
