package com.markbudai.openfleet.framework;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

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
}
