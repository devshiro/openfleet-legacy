package com.markbudai.openfleet.pojo;

import com.markbudai.openfleet.model.Transport;

import java.util.Currency;
import java.util.List;

/**
 * Class representing a payout for an employee.
 * <p>It could be weekly, monthly, yearly, depends on the implementation.</p>
 */
public class Payout {
    private long work_days;
    private long rest_days;
    private long amount;
    private Currency currency;
    private List<Transport> billedTransport;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.pojo.Payout} object.
     * <p>It also sets the default {@link java.util.Currency} to EUR.</p>
     */
    public Payout(){
        currency = Currency.getInstance("EUR");
    }

    /**
     * Gets the work days for the payout period.
     * @return the work days in the payout period.
     */
    public long getWorkDays() {
        return work_days;
    }

    /**
     * Sets the work days for the payout period.
     * @param work_days the work days in the payout period.
     */
    public void setWorkDays(long work_days) {
        this.work_days = work_days;
    }

    /**
     * Gets the rest days for the payout period.
     * @return the rest days in the payout period.
     */
    public long getRestDays() {
        return rest_days;
    }

    /**
     * Sets the rest days for the payout period.
     * @param rest_days the rest days for the payout period.
     */
    public void setRestDays(long rest_days) {
        this.rest_days = rest_days;
    }

    /**
     * Gets the payment given to the employee for the payout period.
     * @return the payment given to the employee for the payout period.
     */
    public long getAmount(){
        return amount;
    }

    /**
     * Sets the payment given to the employee for the payout period.
     * @param amount the payment given to the employee for the payout period.
     */
    public void setAmount(long amount){
        this.amount = amount;
    }

    /**
     * Gets the {@link java.util.Currency} of the payment given to the employee for the payout period.
     * @return the {@link java.util.Currency} of the payment given to the employee for the payout period.
     */
    public Currency getCurrency(){
        return currency;
    }

    /**
     * Gets the symbol of the {@link java.util.Currency} of the payment given to the employee for the payout period.
     * @return the symbol of the {@link java.util.Currency} of the payment given to the employee for the payout period.
     */
    public String getCurrencySymbol(){
        return currency.getSymbol();
    }

    /**
     * Sets the {@link java.util.Currency} of the payment given to the employee for the payout period.
     * @param currency the {@link java.util.Currency} of the payment given to the employee for the payout period.
     */
    public void setCurrency(Currency currency){
        this.currency = currency;
    }

    /**
     * Sets the {@link java.util.Currency} of the payment given to the employee for the payout period using a currency code.
     * @param currencyCode the {@link java.lang.String} currency code of the {@link java.util.Currency}.
     */
    public void setCurrency(String currencyCode){
        this.currency = Currency.getInstance(currencyCode);
    }

    /**
     * Gets a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s which the employee finished and counted in for the payment calculations.
     * @return the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s which the employee finished and counted in for the payment calculations.
     */
    public List<Transport> getBilledTransports(){
        return billedTransport;
    }

    /**
     * Sets the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s which the employee finished and counted in for the payment calculations.
     * @param transport the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s which the employee finished and counted in for the payment calculations.
     */
    public void setBilledTransport(List<Transport> transport){
        billedTransport = transport;
    }

    /**
     * Adds a {@link com.markbudai.openfleet.model.Transport} to the payment calculations.
     * @param transport the {@link com.markbudai.openfleet.model.Transport} to be added to the payment calculations.
     */
    public void addTransport(Transport transport){
        billedTransport.add(transport);
    }

    @Override
    public String toString() {
        String ret = new StringBuilder().append("Payout: ").append(amount).append(" ").append(currency.getSymbol())
                .append(" for ")
                .append(work_days).append(" worked days, ")
                .append(rest_days).append(" rest days, ").toString();
        return ret;
    }
}
