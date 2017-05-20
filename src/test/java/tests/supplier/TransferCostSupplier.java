package tests.supplier;

import com.markbudai.openfleet.model.TransferCost;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Created by Mark on 2017. 05. 20..
 */
public class TransferCostSupplier {
    public static TransferCost getSampleTransferCost(){
        TransferCost transferCost = new TransferCost();
        transferCost.setId(1);
        transferCost.setDate(LocalDate.now());
        transferCost.setCurrency(Currency.getInstance("HUF"));
        transferCost.setAmount(1);
        transferCost.setCostDescription("SAMPLE");
        return transferCost;
    }
}
