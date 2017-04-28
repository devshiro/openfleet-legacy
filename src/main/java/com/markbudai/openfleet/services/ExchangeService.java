package com.markbudai.openfleet.services;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Mark on 2017. 04. 13..
 */
public interface ExchangeService {
    public double getExchangeRateForCurrency(Currency currency);
    public BigDecimal exchange(Currency from, BigDecimal amount, Currency to);
}