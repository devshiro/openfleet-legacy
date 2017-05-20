package tests.builder;

import com.markbudai.openfleet.framework.builder.TrailerBuilder;
import com.markbudai.openfleet.model.Trailer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.WebRequest;
import tests.supplier.TrailerSupplier;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TrailerBuilderTest {
    private static WebRequest mockedWebRequest;

    @BeforeClass
    public static void setup(){
        mockedWebRequest = Mockito.mock(WebRequest.class);
        Mockito.when(mockedWebRequest.getParameter("id")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("type")).thenReturn("Samplerunner");
        Mockito.when(mockedWebRequest.getParameter("manufacturer")).thenReturn("Sample Co");
        Mockito.when(mockedWebRequest.getParameter("date_of_manufacture")).thenReturn("1999-01-01");
        Mockito.when(mockedWebRequest.getParameter("date_of_acquire")).thenReturn("2017-01-01");
        Mockito.when(mockedWebRequest.getParameter("date_of_supervision")).thenReturn("2017-05-05");
        Mockito.when(mockedWebRequest.getParameter("plate_number")).thenReturn("SAM-LPE");
        Mockito.when(mockedWebRequest.getParameter("chassis_number")).thenReturn("SSSAMPLE");
        Mockito.when(mockedWebRequest.getParameter("weight")).thenReturn("1");
        Mockito.when(mockedWebRequest.getParameter("max_load_weight")).thenReturn("100");
    }

    @Test
    public void assertSameTrailers(){
        Trailer trailer = TrailerSupplier.getSampleTrailer();
        trailer.setDate_of_supervision(LocalDate.of(2017,05,05));
        Assert.assertEquals(trailer,TrailerBuilder.buildFromWebRequest(mockedWebRequest));
    }

    @Test
    public void assertSameTrailersHasSameHashCode(){
        Trailer trailer = TrailerSupplier.getSampleTrailer();
        trailer.setDate_of_supervision(LocalDate.of(2017,05,05));
        Assert.assertEquals(trailer.hashCode(),TrailerBuilder.buildFromWebRequest(mockedWebRequest).hashCode());
    }
}
