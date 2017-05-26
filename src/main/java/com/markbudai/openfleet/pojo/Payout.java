package com.markbudai.openfleet.pojo;

import com.markbudai.openfleet.model.Transport;

import java.util.Currency;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class Payout {
    private long work_days;
    private long rest_days;
    private long amount;
    private Currency currency;
    private List<Transport> billedTransport;

    public Payout(){
        currency = Currency.getInstance("EUR");
    }

    public long getWorkDays() {
        return work_days;
    }

    public void setWorkDays(long work_days) {
        this.work_days = work_days;
    }

    public long getRestDays() {
        return rest_days;
    }

    public void setRestDays(long rest_days) {
        this.rest_days = rest_days;
    }

    public long getAmount(){
        return amount;
    }

    public void setAmount(long amount){
        this.amount = amount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public String getCurrencySymbol(){
        return currency.getSymbol();
    }

    public void setCurrency(Currency currency){
        this.currency = currency;
    }

    public void setCurrency(String currencyCode){
        this.currency = Currency.getInstance(currencyCode);
    }

    public List<Transport> getBilledTransports(){
        return billedTransport;
    }

    public void setBilledTransport(List<Transport> transport){
        billedTransport = transport;
    }

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
