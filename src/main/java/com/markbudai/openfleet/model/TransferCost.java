package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.util.Currency;

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
    private Currency currency;

    public TransferCost(){}

    public TransferCost(String costDescription, long amount, Currency currency) {
        this.costDescription = costDescription;
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferCost)) return false;

        TransferCost that = (TransferCost) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (costDescription != null ? !costDescription.equals(that.costDescription) : that.costDescription != null)
            return false;
        return currency != null ? currency.equals(that.currency) : that.currency == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (costDescription != null ? costDescription.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
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
}
