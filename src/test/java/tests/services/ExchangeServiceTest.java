package tests.services;

import com.markbudai.openfleet.services.ExchangeService;
import com.markbudai.openfleet.services.implementations.MNBExchangeService;
import mnb.MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Currency;

/**
 * Created by Mark on 2017. 05. 28..
 */
public class ExchangeServiceTest {
    private static ExchangeService exchangeService;



    @BeforeClass
    public static void init() throws MNBArfolyamServiceSoapGetCurrentExchangeRatesStringFaultFaultMessage, IOException {
       mnb.MNBArfolyamServiceSoap mockedSoap = Mockito.mock(mnb.MNBArfolyamServiceSoap.class);
       Resource mockedResponse = new ClassPathResource("staticExchangeRate.xml");
       String content = new String(Files.readAllBytes(mockedResponse.getFile().toPath()));
       Mockito.when(mockedSoap.getCurrentExchangeRates()).thenReturn(content);
       exchangeService = new MNBExchangeService(mockedSoap);
    }

    @Test
    public void testUSDRate(){
        Assert.assertEquals(273.79,exchangeService.getExchangeRateForCurrency(Currency.getInstance("USD")),0.001);
    }

    @Test
    public void testFromExchangeGetUSDRate(){
        Assert.assertEquals(273,exchangeService.exchange(Currency.getInstance("USD"), BigDecimal.valueOf(1),Currency.getInstance("HUF")).longValue());
    }

    @Test
    public void testExchangeFromUSDToEUR(){
        Assert.assertEquals(44.54,exchangeService.exchange(Currency.getInstance("USD"),BigDecimal.valueOf(50),Currency.getInstance("EUR")).doubleValue(),0.01);
    }

    public static void main(String[] args) throws IOException {
        System.out.println();
    }
}
