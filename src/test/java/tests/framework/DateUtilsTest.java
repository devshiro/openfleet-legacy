package tests.framework;

import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.TransferCost;
import com.markbudai.openfleet.model.Transport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.supplier.TransportSupplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class DateUtilsTest {
    private static List<Transport> transports;

    @BeforeClass
    public static void init(){
        transports = TransportSupplier.getDateList();
    }

    @Test
    public void SameDaysCountsAsOne(){
        long days = DateUtils.getWorkDaysBetween(LocalDate.of(2017,10,10), LocalDate.of(2017,10,10));
        Assert.assertEquals(1,days);
    }

    @Test
    public void OneWeekCountsAsSeven(){
        long days = DateUtils.getWorkDaysBetween(LocalDate.of(2017,5,8), LocalDate.of(2017,5,14));
        Assert.assertEquals(7,days);
    }

    @Test
    public void testFreeDaysCalculation(){
        Assert.assertEquals(7, DateUtils.getFreeDays(transports));
    }
}
