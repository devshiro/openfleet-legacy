package tests;

import com.markbudai.openfleet.framework.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class DateUtilsTest {

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
}
