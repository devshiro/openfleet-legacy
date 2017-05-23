package com.markbudai.openfleet.services;

import com.markbudai.openfleet.exception.NullException;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.PaymentDetail;
import com.markbudai.openfleet.pojo.Payout;
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

    private EmployeeService employeeService;
    private TransportService transportService;
    private MNBExchangeService exchangeService;

    @Autowired
    public PaymentService(EmployeeService employeeService, TransportService transportService){
        this.employeeService = employeeService;
        this.transportService = transportService;
    }


    public long getWorkDaysForEmployeeById(long id){
        Employee e = employeeService.getEmployeeById(id);
        List<Transport> transports = transportService.getTransportByEmployee(e);
        return transports.stream().mapToLong(f-> DateUtils.getWorkDaysBetween(f.getTimeOfLoad(),f.getTimeOfUnload())).sum();
    }

    private long getWorkedDaysForTransports(List<Transport> transports){
        return transports.stream().mapToLong(c-> DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish())).sum();
    }

    //TODO: test totalCostOfTransport
    public double totalCostOfTransport(long id, Currency currency){
        Transport transport = transportService.getTransportById(id);
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

    /*========================================================*/
    /*===========CORRECT STUFF BELOW HERE=====================*/
    public List<Transport> getThisMonthsTransportsForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        LocalDate currentDate = LocalDate.now();
        logger.debug("Get transports for employee {}",e);
        logger.debug("In month: {}",currentDate.getMonth());
        List<Transport> allTransports = transportService.getTransportByEmployee(e);
        logger.debug("Found {} transports total",allTransports.size());
        List<Transport> thisMonthTransports = allTransports.stream()
                .filter(t->t.getStart().getYear() == currentDate.getYear())
                .filter(t->t.getStart().getMonth().getValue() == currentDate.getMonth().getValue())
                .collect(Collectors.toList());
        logger.debug("In this month, found {} transports",thisMonthTransports.size());
        return thisMonthTransports;
    }


    public long getWorkDaysInThisMonthForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        logger.debug("Collecting this month's transports for employee: {}",e);
        List<Transport> transports = getThisMonthsTransportsForEmployee(e);
        logger.debug("Found {} transports.",transports.size());
        long days = transports.stream().mapToLong(m->DateUtils.getWorkDaysBetween(m.getStart(),m.getFinish())).sum();
        logger.debug("Employee has {} work days in this month.",days);
        return days;
    }

    public long getTotalWorkDaysForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        logger.debug("Collecting transports for employee: {}",e);
        List<Transport> transports = transportService.getTransportByEmployee(e);
        logger.debug("Found {} transports for employee",transports.size());
        long days = transports.stream().mapToLong(m->DateUtils.getWorkDaysBetween(m.getStart(),m.getFinish())).sum();
        return days;
    }

    public long getPayoutForSingleTransport(Transport t){
        long workedDays = DateUtils.getWorkDaysBetween(t.getStart(),t.getFinish());
        return workedDays*this.dailyFee;
    }

    public List<PaymentDetail> getPaymentsInThisMonthForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        List<Transport> transports = getThisMonthsTransportsForEmployee(e);
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        transports.forEach(c->{
            PaymentDetail detail = new PaymentDetail(LocalDate.now(),
                    DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish()),
                    getPayoutForSingleTransport(c));
            paymentDetails.add(detail);
        });
        return paymentDetails;
    }

    public List<PaymentDetail> getAllPaymentsForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        List<Transport> transports = transportService.getTransportByEmployee(e);
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        transports.forEach(c->{
            PaymentDetail detail = new PaymentDetail(c.getStart().toLocalDate(),
                    DateUtils.getWorkDaysBetween(c.getStart(),c.getFinish()),
                    getPayoutForSingleTransport(c));
            paymentDetails.add(detail);
        });
        return paymentDetails;
    }

    public Payout getPayoutInThisMonthForEmployee(Employee e){
        if(e==null) throw new NullException(Employee.class);
        logger.debug("Creating Payment object for employee {}",e);
        Payout payout = new Payout();
        payout.setWorkDays(getWorkDaysInThisMonthForEmployee(e));
        payout.setRestDays(LocalDate.now().getDayOfMonth()-getWorkDaysInThisMonthForEmployee(e));
        payout.setDetailList(getPaymentsInThisMonthForEmployee(e));
        return payout;
    }
}
