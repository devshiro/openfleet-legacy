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
 * Created by Mark on 2017. 05. 13..
 */
public class DateUtils {

    public static long getWorkDaysBetween(Temporal from, Temporal to){
        return Math.abs(ChronoUnit.DAYS.between(from,to)+1);
    }

    public static long getDaysDifference(Temporal from, Temporal to){
        return Math.abs(ChronoUnit.DAYS.between(from,to));
    }

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
