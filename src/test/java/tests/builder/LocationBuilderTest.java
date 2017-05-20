package tests.builder;

import com.markbudai.openfleet.framework.builder.LocationBuilder;
import com.markbudai.openfleet.model.Location;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Mark on 2017. 05. 14..
 */
public class LocationBuilderTest {
    private static WebRequest request;

    @BeforeClass
    public static void setup(){
        request = Mockito.mock(WebRequest.class);
        Mockito.when(request.getParameter("id")).thenReturn("1");
        Mockito.when(request.getParameter("country")).thenReturn("A");
        Mockito.when(request.getParameter("city")).thenReturn("B");
        Mockito.when(request.getParameter("region")).thenReturn("C");
        Mockito.when(request.getParameter("street")).thenReturn("D");
        Mockito.when(request.getParameter("houseNo")).thenReturn("E");
        Mockito.when(request.getParameter("zipcode")).thenReturn("1");
    }

    @Test
    public void testBuildFromRequest(){
        Location actual = LocationBuilder.buildFromWebRequest(request);
        Location expected = buildTestLocation();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testBuildFromRequestHasSameHashCode(){
        Assert.assertEquals(buildTestLocation().hashCode(),LocationBuilder.buildFromWebRequest(request).hashCode());
    }

    private static Location buildTestLocation(){
        LocationBuilder builder = new LocationBuilder();
        return builder.id(1).country("A").city("B").region("C").street("D").houseNo("E")
                .zipcode("1").build();
    }
}
