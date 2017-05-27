package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

/**
 * Class representing an expense during a transport job.
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

    /**
     * Empty constructor for creating a {@link com.markbudai.openfleet.model.TransferCost} object.
     */
    public TransferCost(){}

    /**
     * Constructor for creating a {@link com.markbudai.openfleet.model.TransferCost} object.
     * @param costDescription a short description of the expense.
     * @param amount the amount of the expense.
     * @param date the date when the expense happened.
     * @param currency the currency of the expense.
     */
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

    /**
     * Gets the {@link java.time.LocalDate} of the expense.
     * @return the {@link java.time.LocalDate} of the expense.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the {@link java.time.LocalDate} of the expense.
     * @param date the {@link java.time.LocalDate} of the expense.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} object.
     * @return the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} object.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.TransferCost} object.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the short description of the expense.
     * @return the short description of the expense.
     */
    public String getCostDescription() {
        return costDescription;
    }

    /**
     * Sets the short description of the expense.
     * @param costDescription the short description of the expense.
     */
    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    /**
     * Gets the amount of the expense.
     * @return the amount of the expense.
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the expense.
     * @param amount the amount of the expense.
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    /**
     * Gets the {@link java.util.Currency} of the expense.
     * @return the {@link java.util.Currency} of the expense.
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets the {@link java.util.Currency} of the expense.
     * @param currency the {@link java.util.Currency} of the expense.
     */
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
