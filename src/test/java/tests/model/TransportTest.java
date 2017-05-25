package tests.model;

import com.markbudai.openfleet.model.Transport;
import org.junit.Assert;
import org.junit.Test;
import tests.supplier.TransportSupplier;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 24..
 */
public class TransportTest {

    @Test
    public void testFilterByYear(){
        List<Transport> transports = TransportSupplier.getDateList();
        Assert.assertEquals(0,Transport.filter(2016,transports).size());
        Assert.assertEquals(4,Transport.filter(2017,transports).size());
    }

    @Test
    public void testFilterByMonth(){
        List<Transport> transports = TransportSupplier.getDateList();
        Assert.assertEquals(3,Transport.filter(2017,1,transports).size());
        Assert.assertEquals(1,Transport.filter(2017,2,transports).size());
    }

    @Test
    public void testFilterByDay(){
        List<Transport> transports = TransportSupplier.getDateList();
        Assert.assertEquals(1,Transport.filter(2017,2,4,transports).size());
        Assert.assertEquals(4,Transport.filter(LocalDate.of(2017,1,8),TransportSupplier.getTransportsOnSameDay()).size());
    }
}
