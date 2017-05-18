package com.markbudai.openfleet.framework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class DateUtils {

    public static long getDaysBetween(Temporal from, Temporal to){
        return Math.abs(ChronoUnit.DAYS.between(from,to) + 1);
    }
}