package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

/**
 * Created by Mark on 2017. 04. 13..
 */
@Entity
@Table(name = "transfercost")
public class TransferCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String costDescription;
    private long amount;
    private LocalDate date;
    private Currency currency;

    public TransferCost(){}

    public TransferCost(String costDescription, long amount, LocalDate date, Currency currency) {
        this.costDescription = costDescription;
        this.amount = amount;
        this.date = date;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferCost)) return false;

        TransferCost that = (TransferCost) o;

        if (getAmount() != that.getAmount()) return false;
        if (getCostDescription() != null ? !getCostDescription().equals(that.getCostDescription()) : that.getCostDescription() != null)
            return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        return getCurrency() != null ? getCurrency().equals(that.getCurrency()) : that.getCurrency() == null;
    }

    @Override
    public int hashCode() {
        int result = getCostDescription() != null ? getCostDescription().hashCode() : 0;
        result = 31 * result + (int) (getAmount() ^ (getAmount() >>> 32));
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        return result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    @Override
    public String toString(){
        return new StringBuilder().append(this.getAmount()).append(" ").append(this.getCurrency().getSymbol())
                .append(" for ").append(this.getCostDescription())
                .toString();
    }
}
