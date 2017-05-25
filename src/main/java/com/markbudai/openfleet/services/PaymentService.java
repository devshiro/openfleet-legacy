package com.markbudai.openfleet.services;

import com.markbudai.openfleet.exception.NullException;
import com.markbudai.openfleet.framework.DateUtils;
import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.Payout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
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

    /*-----------------------------------------------------------------------------------------*/
    public long getWorkDays(List<Transport> transports){
        if(transports.size() > 0){
            List<Transport> sortedList = transports.stream().sorted(Comparator.comparing(Transport::getStart)).collect(Collectors.toList());
            long duration = ChronoUnit.DAYS.between(sortedList.get(0).getStart().toLocalDate(),sortedList.get(sortedList.size()-1).getFinish().toLocalDate()) + 1;
            return duration - DateUtils.getFreeDays(transports);
        } else {
            return 0;
        }
    }

    public Payout getPayout(Employee employee, int year, int month){
        if(employee == null) throw new NullException(Employee.class);
        Payout payout = new Payout();
        payout.setCurrency(this.feeCurrency);
        LocalDate today = LocalDate.now();
        if(year != today.getYear()  || month != today.getMonth().getValue()){
            today = LocalDate.of(year,month,LocalDate.of(year,month,1).lengthOfMonth());
        }
        List<Transport> transports = transportService.getTransportByEmployee(employee);
        transports = Transport.filter(year, month, transports);
        Optional<Transport> firstTransport = transports.stream().min(Comparator.comparing(Transport::getFinish));
        Optional<Transport> lastTransport = transports.stream().max(Comparator.comparing(Transport::getFinish));
        if (lastTransport.isPresent() && firstTransport.isPresent()) {
            LocalDate lastWorkDay = lastTransport.get().getFinish().toLocalDate();
            LocalDate firstWorkDay = firstTransport.get().getStart().toLocalDate();
            logger.debug("First work day for {} : {}", employee, firstWorkDay);
            logger.debug("Last work day for {} : {}", employee, lastWorkDay);
            long workDays = this.getWorkDays(transports);
            long restDays = DateUtils.getFreeDays(transports);


            if (firstWorkDay.getMonth().equals(today.getMonth())) {
                restDays += ChronoUnit.DAYS.between(LocalDate.of(today.getYear(), today.getMonth(), 1), firstWorkDay);
                logger.debug("Before days: {}", ChronoUnit.DAYS.between(LocalDate.of(today.getYear(), today.getMonth(), 1), firstWorkDay));
            }
            if (lastWorkDay.getMonth().equals(today.getMonth())) {
                restDays += ChronoUnit.DAYS.between(lastWorkDay, today);
                logger.debug("After days: {}", ChronoUnit.DAYS.between(lastWorkDay, today));
            }

            logger.debug("Work days: {}, Rest days: {}", workDays, restDays);
            double totalBilledDays = workDays + restDays;
            logger.debug("total bill days: {}", totalBilledDays);

            payout.setRestDays(restDays);
            payout.setWorkDays(workDays);
            payout.setBilledTransport(transports);
            payout.setAmount(workDays * this.dailyFee);
        }
        return payout;
    }


    public List<Pair<String,Pair<Double,Double>>> getDriversPerformance(int year, int month) {
        LocalDate today = LocalDate.now();
        if(year != today.getYear()  || month != today.getMonth().getValue()){
            today = LocalDate.of(year,month,LocalDate.of(year,month,1).lengthOfMonth());
        }
        List<Pair<String, Pair<Double, Double>>> performanceList = new ArrayList<>();
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            List<Transport> transports = transportService.getTransportByEmployee(employee);
            transports = Transport.filter(today.getYear(), today.getMonthValue(), transports);
            Optional<Transport> firstTransport = transports.stream().min(Comparator.comparing(Transport::getFinish));
            Optional<Transport> lastTransport = transports.stream().max(Comparator.comparing(Transport::getFinish));
            if (lastTransport.isPresent() && firstTransport.isPresent()) {
                LocalDate lastWorkDay = lastTransport.get().getFinish().toLocalDate();
                LocalDate firstWorkDay = firstTransport.get().getStart().toLocalDate();
                logger.debug("First work day for {} : {}", employee, firstWorkDay);
                logger.debug("Last work day for {} : {}", employee, lastWorkDay);
                double workDays = this.getWorkDays(transports);
                double restDays = DateUtils.getFreeDays(transports);


                if (firstWorkDay.getMonth().equals(today.getMonth())) {
                    restDays += ChronoUnit.DAYS.between(LocalDate.of(today.getYear(), today.getMonth(), 1), firstWorkDay);
                    logger.debug("Before days: {}",ChronoUnit.DAYS.between(LocalDate.of(today.getYear(), today.getMonth(), 1), firstWorkDay));
                }
                if (lastWorkDay.getMonth().equals(today.getMonth())) {
                    restDays += ChronoUnit.DAYS.between(lastWorkDay, today);
                    logger.debug("After days: {}",ChronoUnit.DAYS.between(lastWorkDay, today));
                }

                logger.debug("Work days: {}, Rest days: {}",workDays,restDays);
                double totalBilledDays = workDays + restDays;

                logger.debug("total bill days: {}",totalBilledDays);

                Pair<Double, Double> daysPair = Pair.of(workDays / totalBilledDays, restDays / totalBilledDays);
                String employeeName = new StringBuilder().append(employee.getFirstName()).append(" ").append(employee.getLastName()).toString();
                Pair<String, Pair<Double, Double>> employeePair = Pair.of(employeeName, daysPair);
                performanceList.add(employeePair);
            }
        }
        return performanceList;
    }
}
