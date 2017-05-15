package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.model.TransferCost;

import java.util.Currency;

/**
 * Created by Mark on 2017. 05. 09..
 */
public class TransferCostBuilder {
    public static TransferCost build(long amount, Currency currency, String description){
        TransferCost t = new TransferCost();
        t.setAmount(amount);
        t.setCostDescription(description);
        t.setCurrency(currency);
        return t;
    }
}
