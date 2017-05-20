package tests.services;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.PaymentDetail;
import com.markbudai.openfleet.services.PaymentService;
import nz.net.ultraq.thymeleaf.fragments.mergers.ElementMerger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import tests.supplier.EmployeeSupplier;
import tests.supplier.TransportSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class PaymentServiceTest {

    private static EmployeeProvider mockedEmployeeProvider;
    private static TransportProvider mockedTransportProvider;

    private static PaymentService service;

    @BeforeClass
    public static void setup(){
        mockedEmployeeProvider = EmployeeSupplier.getMockProvider();
        mockedTransportProvider = TransportSupplier.getMockProvider();
        service = new PaymentService(mockedEmployeeProvider,mockedTransportProvider);
    }

    @Test
    public void testGetThisMonthsTransportsForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(1,service.getThisMonthsTransportsForEmployee(employee).size());
    }

    @Test
    public void testGetWorkDaysIThisMonthForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(10,service.getWorkDaysInThisMonthForEmployee(employee));
    }

    @Test
    public void testGetPayoutForSingleTransport(){
        Transport transport = TransportSupplier.getSampleTransport();
        Assert.assertEquals(500,service.getPayoutForSingleTransport(transport));
    }

    @Test
    public void testGetPaymentsInThisMonthForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(500,service.getPaymentsInThisMonthForEmployee(employee).get(0).getTotalPayout());
    }

    @Test
    public void testTotalWorkDaysForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(20,service.getTotalWorkDaysForEmployee(employee));
    }

    @Test
    public void testAllPaymentsForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(2,service.getAllPaymentsForEmployee(employee).size());
    }

    @Test
    public void testPayoutInThisMonthForEmployee(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        Assert.assertEquals(10,service.getPayoutInThisMonthForEmployee(employee).getWork_days());
    }
}
