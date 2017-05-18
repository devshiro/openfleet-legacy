package com.markbudai.openfleet.pojo;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 16..
 */
public class PaymentDetail {
    private int year;
    private int month;
    private long workedDays;
    private long totalPayout;

    public PaymentDetail(LocalDate date, long workedDays, long totalPayout) {
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.workedDays = workedDays;
        this.totalPayout = totalPayout;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(long workedDays) {
        this.workedDays = workedDays;
    }

    public long getTotalPayout() {
        return totalPayout;
    }

    public void setTotalPayout(long totalPayout) {
        this.totalPayout = totalPayout;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("PaymentDetail{")
                .append("year=").append(year)
                .append(", month=").append(month)
                .append(", workedDays=").append(workedDays)
                .append(", totalPayout=").append(totalPayout)
                .append('}').toString();
    }
}
