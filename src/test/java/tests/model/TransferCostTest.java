package tests.model;

import com.markbudai.openfleet.model.TransferCost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.supplier.TransferCostSupplier;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Created by Mark on 2017. 05. 20..
 */
public class TransferCostTest {
    private static TransferCost one;
    private static TransferCost two;


    @BeforeClass
    public static void init(){
        one = TransferCostSupplier.getSampleTransferCost();
        two = TransferCostSupplier.getSampleTransferCost();
    }

    @Before
    public void reset(){
        init();
    }

    @Test
    public void twoAreSame(){
        Assert.assertEquals(one,two);
    }

    @Test
    public void notEqualsIfAmountDifferent(){
        one.setAmount(2);
        Assert.assertNotEquals(one,two);
    }

    @Test
    public void notEqualsIfDateIsDifferent(){
        one.setDate(LocalDate.now().minusDays(1));
        Assert.assertNotEquals(one,two);
    }

    @Test
    public void notEqualsIfCurrencyIsDifferent(){
        one.setCurrency(Currency.getInstance("EUR"));
        Assert.assertNotEquals(one,two);
    }

    @Test
    public void notEqualsIfCostDescriptionIsDifferent(){
        one.setCostDescription("2");
        Assert.assertNotEquals(one,two);
    }
}
