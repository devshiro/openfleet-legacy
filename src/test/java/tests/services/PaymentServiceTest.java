package tests.services;

import com.markbudai.openfleet.pojo.Payout;
import com.markbudai.openfleet.services.EmployeeService;
import com.markbudai.openfleet.services.implementations.PaymentServiceImpl;
import com.markbudai.openfleet.services.TransportService;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.services.PaymentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import tests.supplier.EmployeeSupplier;
import tests.supplier.TransportSupplier;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class PaymentServiceTest {

    private static EmployeeService mockedEmployeeService;
    private static TransportService mockedTransportService;

    private static PaymentService service;

    @BeforeClass
    public static void init(){
        mockedEmployeeService = EmployeeSupplier.getMockProvider();
        mockedTransportService = TransportSupplier.getMockProvider();
        service = new PaymentServiceImpl(mockedEmployeeService, mockedTransportService);
    }

    @Test
    public void testPayoutGeneration(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Payout payout = service.getPayout(employee,2017,LocalDate.now().getMonthValue());
        Assert.assertEquals(500,payout.getAmount());
        Assert.assertEquals(10,payout.getWorkDays());
    }

    @Test
    public void testWorkDays(){
        List<Transport> transports = TransportSupplier.getDateList();
        Assert.assertEquals(32,service.getWorkDays(transports));
    }

    @Test
    public void testWorkDaysAgainst3TransportsOnOneDay(){
        List<Transport> transports = TransportSupplier.getTransportsOnSameDay();
        Assert.assertEquals(1,service.getWorkDays(transports));
    }

    @Test
    public void testDriversPerformanceEval(){
        mockedTransportService = Mockito.mock(TransportService.class);
        Mockito.when(mockedTransportService.getTransportByEmployee(EmployeeSupplier.getSampleEmployee()))
                .thenReturn(TransportSupplier.getDateList());
        PaymentService service = new PaymentServiceImpl(mockedEmployeeService,mockedTransportService);
        Assert.assertEquals(0.8,service.getDriversPerformance(2017,1).get(0).getSecond().getFirst(),0.001);
        Assert.assertEquals(0.2,service.getDriversPerformance(2017,1).get(0).getSecond().getSecond(),0.001);
    }
}
