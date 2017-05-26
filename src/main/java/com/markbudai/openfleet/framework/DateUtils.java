package com.markbudai.openfleet.framework;

import com.markbudai.openfleet.model.Transport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for calculations involving {@link java.time.LocalDate} and {@link java.time.LocalDateTime}.
 */
public class DateUtils {

    /**
     * Calculates the days in the interval represented by two {@link java.time.temporal.Temporal}s.
     * If the two {@link java.time.temporal.Temporal}s are on the same day, that still counts as a work day.
     * @param from the {@link java.time.temporal.Temporal} representing the beginning of the interval.
     * @param to the {@link java.time.temporal.Temporal} representing the end of the interval.
     * @return the days between the two {@link java.time.temporal.Temporal}s.
     */
    public static long getWorkDaysBetween(Temporal from, Temporal to){
        return Math.abs(ChronoUnit.DAYS.between(from,to)+1);
    }

    /**
     * Returns the days in the interval represented by two {@link java.time.temporal.Temporal}s.
     * If the two {@link java.time.temporal.Temporal}s are on the same day, that counts as zero.
     * @param from the {@link java.time.temporal.Temporal} representing the beginning of the interval.
     * @param to the {@link java.time.temporal.Temporal} representing the end of the interval.
     * @return the days between the two {@link java.time.temporal.Temporal}s.
     */
    public static long getDaysDifference(Temporal from, Temporal to){
        return Math.abs(ChronoUnit.DAYS.between(from,to));
    }

    /**
     * Calculates the free days (days not listed in {@link com.markbudai.openfleet.model.Transport}s) in a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     * Free days are occuring as gaps between the end of a {@link com.markbudai.openfleet.model.Transport} and the start of the next {@link com.markbudai.openfleet.model.Transport}.
     * @param transportList the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     * @return the number of free days.
     */
    public static long getFreeDays(List<Transport> transportList){
        List<Transport> list = transportList.stream().sorted(Comparator.comparing(Transport::getStart)).collect(Collectors.toList());
        long freeDays = 0;
        for(int i = 0; i < list.size() -1; i++){
            long daysBetween = Duration.between(list.get(i).getFinish(),list.get(i+1).getStart()).toDays();
            if(daysBetween > 0){
                freeDays+=(daysBetween - 1);
            }
        }
        return freeDays;
    }
}
