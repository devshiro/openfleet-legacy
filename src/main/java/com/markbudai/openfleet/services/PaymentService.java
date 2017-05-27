package com.markbudai.openfleet.services;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Transport;
import com.markbudai.openfleet.pojo.Payout;
import org.springframework.data.util.Pair;

import java.util.List;

/**
 * Interface describing operations to manage employee payments.
 */
public interface PaymentService {
    /**
     * Calculates the work days from a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     * @param transports the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     * @return the number of worked days.
     */
    long getWorkDays(List<Transport> transports);

    /**
     * Gets a {@link com.markbudai.openfleet.pojo.Payout} object representing payout given for the employee in the given year and month.
     * @param employee the {@link com.markbudai.openfleet.model.Employee} whose payment information needs to be generated.
     * @param year the year of the payment.
     * @param month the month of the payment.
     * @return the {@link com.markbudai.openfleet.pojo.Payout} object representing payout given for the employee in the given year and month.
     */
    Payout getPayout(Employee employee, int year, int month);

    /**
     * Calculates a percentage value for work / rest days for all employees in the given year and month.
     * @param year the year to be evaluated.
     * @param month the month to be evaluated.
     * @return a {@link java.util.List} of {@link org.springframework.data.util.Pair}s containing the driver's name and work / rest days percentages.
     */
    List<Pair<String,Pair<Double,Double>>> getDriversPerformance(int year, int month);
}
