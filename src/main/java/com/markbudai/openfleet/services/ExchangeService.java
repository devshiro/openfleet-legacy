package com.markbudai.openfleet.services;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Interface describing operations to exchange a {@link java.math.BigDecimal} value between different {@link java.util.Currency}.
 */
public interface ExchangeService {
    /**
     * Gets the exchange rate relative to a base currency for given {@link java.util.Currency}.
     * @param currency the {@link java.util.Currency} needs to be converted.
     * @return the exchange rate relative to a base currency.
     */
    double getExchangeRateForCurrency(Currency currency);

    /**
     * Converts a {@link java.math.BigDecimal} value from one currency to another.
     * @param from {@link java.util.Currency} of the value.
     * @param amount the value to be converted.
     * @param to the {@link java.util.Currency} the value needs to be converted to.
     * @return the amount in the target currency.
     */
    BigDecimal exchange(Currency from, BigDecimal amount, Currency to);
}