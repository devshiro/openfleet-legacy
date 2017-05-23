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

    public long getTotalPayment() {
        return detailList.stream().mapToLong(p->p.getTotalPayout()).sum();
    }

    public void setTotalPayment(long total_payment) {
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
