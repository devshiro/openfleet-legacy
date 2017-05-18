package com.markbudai.openfleet.services;

import com.markbudai.openfleet.dao.providers.EmployeeProvider;
import com.markbudai.openfleet.dao.providers.TransportProvider;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.PaymentDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 05. 13..
 */
@Service
public class PaymentService {

    private static Logger logger = LoggerFactory.getLogger(PaymentService.class);

    //TODO: Strore dailyFee and currency in DB. (Probably key-value store) {Redis if i have a lot of time... a LOT.}
    private long dailyFee = 50;
    private Currency feeCurrency = Currency.getInstance("EUR");

    private EmployeeProvider employeeProvider;
    private TransportProvider transportProvider;
    private MNBExchangeService exchangeService;

    @Autowired
    public PaymentService(EmployeeProvider employeeProvider, TransportProvider transportProvider){
        this.employeeProvider = employeeProvider;
        this.transportProvider = transportProvider;
    }


    public long getWorkDaysForEmployeeById(long id){
        Employee e = employeeProvider.getEmployeeById(id);
        if(e == null){ return -1L; }
        List<Transport> transports = transportProvider.getTransportByEmployee(e);
        return transports.stream().mapToLong(f-> DateUtils.getWorkDaysBetween(f.getTime_of_load(),f.getTime_of_unload())).sum();
    }

    private long getWorkedDaysForTransports(List<Transport> transports){
        return transports.stream().mapToLong(c-> DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish())).sum();
    }

    //TODO: test totalCostOfTransport
    public double totalCostOfTransport(long id, Currency currency){
        Transport transport = transportProvider.getTransportById(id);
        double sum = transport.getCosts().stream().mapToDouble((f)->{
            //convert currency to given function argument {currency}
            BigDecimal costInCurrency = exchangeService.exchange(f.getCurrency(),new BigDecimal(f.getAmount()),currency);
            return costInCurrency.doubleValue();
        }).sum();
        return sum;
    }

    //TODO: Fix monthly payment calculations
    public BigDecimal getMonthlyFeeForEmployee(Employee e){
        long workedDays = getWorkDaysForEmployeeById(e.getId());
        long money = workedDays * dailyFee;
        return new BigDecimal(money);
    }

    public List<PaymentDetail> getPaymentsForEmployee(long id)
    {
        LocalDate currentDate = LocalDate.now();

        Employee employee = employeeProvider.getEmployeeById(id);
        if(employee == null){
            return null;
        }
        List<Transport> transports = transportProvider.getTransportByEmployee(employee);
        transports = transports.stream().filter(p->p.getStart().toLocalDate().getYear() == currentDate.getYear())
                .filter(p->p.getStart().getMonth().equals(currentDate.getMonth()))
                .collect(Collectors.toList());
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        transports.forEach(c->{
            paymentDetails.add(new PaymentDetail(LocalDate.now(),DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish()), DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish())*30));
        });
        return paymentDetails;
    }
}
