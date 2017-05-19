package tests;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.LocationProvider;
import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.providers.TrailerProvider;
import com.markbudai.openfleet.framework.builder.TransportBuilder;
import com.markbudai.openfleet.model.Transport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.WebRequest;
import tests.supplier.*;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TransportBuilderTest {
    private static TransportBuilder transportBuilder;
    private static EmployeeProvider mockEmployeeProvider;
    private static LocationProvider mockLocationProvider;
    private static TractorProvider mockTractorProvider;
    private static TrailerProvider mockTrailerProvider;
    private static WebRequest mockWebRequest;

    private static TransportBuilder setupTransportBuilder(){
        mockLocationProvider = LocationSupplier.getMockProvider();
        mockEmployeeProvider = EmployeeSupplier.getMockProvider();
        mockTractorProvider = TractorSupplier.getMockProvider();
        mockTrailerProvider = TrailerSupplier.getMockProvider();
        TransportBuilder transportBuilder = new TransportBuilder(mockEmployeeProvider,mockTractorProvider,mockTrailerProvider,mockLocationProvider);
        return transportBuilder;
    }

    private static WebRequest setupWebRequest(){
        WebRequest request = Mockito.mock(WebRequest.class);
        Mockito.when(request.getParameter("tractor")).thenReturn("1");
        Mockito.when(request.getParameter("trailer")).thenReturn("1");
        Mockito.when(request.getParameter("employee")).thenReturn("1");
        Mockito.when(request.getParameter("cargo_count")).thenReturn("1");
        Mockito.when(request.getParameter("cargo_weight")).thenReturn("1");
        Mockito.when(request.getParameter("cargo_name")).thenReturn("Sample Cargo");
        Mockito.when(request.getParameter("place_of_load")).thenReturn("1");
        Mockito.when(request.getParameter("place_of_unload")).thenReturn("1");
        Mockito.when(request.getParameter("time_of_load")).thenReturn("2017-05-01T08:00");
        Mockito.when(request.getParameter("time_of_unload")).thenReturn("2017-05-10T08:00");
        return request;
    }


    @BeforeClass
    public static void setUp(){
        transportBuilder = setupTransportBuilder();
        mockWebRequest = setupWebRequest();
    }

    @Test
    public void sameAsSample(){
        Transport transport = TransportSupplier.getSampleTransport();
        transport.setStart(null);
        transport.setFinish(null);
        Assert.assertEquals(transport,transportBuilder.buildFromWebRequest(mockWebRequest));
    }

    @Test
    public void assertSameTransportHasSameHashCode(){
        Transport transport = TransportSupplier.getSampleTransport();
        transport.setStart(null);
        transport.setFinish(null);
        Assert.assertEquals(transport.hashCode(),transportBuilder.buildFromWebRequest(mockWebRequest).hashCode());
    }
}
