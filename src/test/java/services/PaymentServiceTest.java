package services;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.PaymentDetail;
import com.markbudai.openfleet.services.PaymentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import supplier.TransportSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class PaymentServiceTest {

    private static EmployeeProvider mockedEmployeeProvider;
    private static TransportProvider mockedTransportProvider;

    private static PaymentService service;


    private static EmployeeProvider setUpMockedEmployeeProvider(){
        EmployeeProvider mocked = Mockito.mock(EmployeeProvider.class);
        Mockito.when(mocked.getEmployeeById(1)).thenReturn(supplier.EmployeeSupplier.getSampleEmployee());
        return mocked;
    }

    private static TransportProvider setUpMockedTransportProvider(){
        TransportProvider mocked = Mockito.mock(TransportProvider.class);
        Transport transport = TransportSupplier.getSampleTransport();
        List<Transport> list = new ArrayList<>();
        list.add(transport);
        Mockito.when(mocked.getTransportByEmployee(mockedEmployeeProvider.getEmployeeById(1))).thenReturn(list);
        return mocked;
    }

    @BeforeClass
    public static void setup(){
        mockedEmployeeProvider = setUpMockedEmployeeProvider();
        mockedTransportProvider = setUpMockedTransportProvider();
        service = new PaymentService(mockedEmployeeProvider,mockedTransportProvider);
    }

    @Test
    public void TestWorkDays(){
        Assert.assertEquals(10,service.getWorkDaysForEmployeeById(1));
    }


    @Test
    public void TestPayment(){
        List<PaymentDetail> list = service.getPaymentsForEmployee(1);
        long total = list.stream().mapToLong(c->c.getTotalPayout()).sum();
        Assert.assertEquals(300,total);
    }
}
