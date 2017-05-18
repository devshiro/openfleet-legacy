package com.markbudai.openfleet.pojo;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class Payout {
    private long work_days;
    private long rest_days;
    private long total_payment;
    private List<PaymentDetail> detailList;

    public Payout(){}

    public long getWork_days() {
        return work_days;
    }

    public void setWork_days(long work_days) {
        this.work_days = work_days;
    }

    public long getRest_days() {
        return rest_days;
    }

    public void setRest_days(long rest_days) {
        this.rest_days = rest_days;
    }

    public long getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(long total_payment) {
        this.total_payment = total_payment;
    }

    public List<PaymentDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<PaymentDetail> detailList) {
        this.detailList = detailList;
    }

    public void addDetail(PaymentDetail detail){
        this.detailList.add(detail);
    }
}
