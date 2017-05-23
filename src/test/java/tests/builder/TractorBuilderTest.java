package tests.builder;

import com.markbudai.openfleet.framework.builder.TractorBuilder;
import com.markbudai.openfleet.model.Tractor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.WebRequest;
import tests.supplier.TractorSupplier;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TractorBuilderTest {
    private static WebRequest mockedWebRequest;

    @BeforeClass
    public static void setup(){
        mockedWebRequest = Mockito.mock(WebRequest.class);
        Mockito.when(mockedWebRequest.getParameter("id")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("type")).thenReturn("SampleV8");
        Mockito.when(mockedWebRequest.getParameter("manufacturer")).thenReturn("Sample");
        Mockito.when(mockedWebRequest.getParameter("date_of_manufacture")).thenReturn("1999-01-01");
        Mockito.when(mockedWebRequest.getParameter("date_of_acquire")).thenReturn("2017-01-01");
        Mockito.when(mockedWebRequest.getParameter("date_of_supervision")).thenReturn("2017-05-05");
        Mockito.when(mockedWebRequest.getParameter("plate_number")).thenReturn("SAM-PLE");
        Mockito.when(mockedWebRequest.getParameter("chassis_number")).thenReturn("SSSSSAMPLE");
        Mockito.when(mockedWebRequest.getParameter("fuel_norm")).thenReturn("1.0");
        Mockito.when(mockedWebRequest.getParameter("weight")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("max_weight")).thenReturn("1000");
    }

    @Test
    public void assertSameTractors(){
        Tractor tractor = TractorSupplier.getSampleTractor();
        tractor.setDateOfSupervision(LocalDate.of(2017,05,05));
        Assert.assertEquals(tractor,TractorBuilder.buildFromWebRequest(mockedWebRequest));
    }

    @Test
    public void assertSameTractorsHasSameHashCode(){
        Tractor tractor = TractorSupplier.getSampleTractor();
        tractor.setDateOfSupervision(LocalDate.of(2017,05,05));
        Assert.assertEquals(tractor.hashCode(),TractorBuilder.buildFromWebRequest(mockedWebRequest).hashCode());
    }
}
