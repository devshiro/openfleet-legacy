package tests.builder;

import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.framework.builder.EmployeeBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.WebRequest;
import tests.supplier.EmployeeSupplier;
import tests.supplier.LocationSupplier;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class EmployeeBuilderTest {
    private static EmployeeBuilder employeeBuilder;
    private static LocationProvider locationProvider;   /* getLocationById(long id)*/
    private static WebRequest mockedWebRequest;


    @BeforeClass
    public static void setup(){
        locationProvider = LocationSupplier.getMockProvider();
        employeeBuilder = new EmployeeBuilder(locationProvider);

        mockedWebRequest = Mockito.mock(WebRequest.class);
        Mockito.when(mockedWebRequest.getParameter("id")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("firstName")).thenReturn("John");
        Mockito.when(mockedWebRequest.getParameter("lastName")).thenReturn("Shepard");
        Mockito.when(mockedWebRequest.getParameter("dateOfBirth")).thenReturn("1993-01-01");
        Mockito.when(mockedWebRequest.getParameter("placeOfBirth")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("socialInsuranceNo")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("taxNo")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("mothersName")).thenReturn("Jane Doe");
        Mockito.when(mockedWebRequest.getParameter("driversCardNo")).thenReturn("2");
        Mockito.when(mockedWebRequest.getParameter("placeOfLiving")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("employmentDate")).thenReturn("2017-05-18");
    }

    @Test
    public void assertWebRequestBuiltAndSampleEmployeesAreTheSame(){
        Assert.assertEquals(EmployeeSupplier.getSampleEmployee(),employeeBuilder.buildFromWebRequest(mockedWebRequest));
    }

    @Test
    public void assertWebRequestBiltAndSampleEmployeesHasTheSameHashCode(){
        Assert.assertEquals(EmployeeSupplier.getSampleEmployee().hashCode(),employeeBuilder.buildFromWebRequest(mockedWebRequest).hashCode());
    }
}
