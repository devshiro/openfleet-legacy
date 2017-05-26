package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.Payout;
import org.springframework.data.util.Pair;

import java.util.List;

/**
 * Created by Mark on 2017. 05. 26..
 */
public interface PaymentService {
    long getWorkDays(List<Transport> transports);

    Payout getPayout(Employee employee, int year, int month);

    List<Pair<String,Pair<Double,Double>>> getDriversPerformance(int year, int month);
}
