package com.kanghai.java8.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/17 0:22
 * @description
 */

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY)
            dayToAdd = 3;
        else if (dow == DayOfWeek.SATURDAY)
            dayToAdd = 2;
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public void adjustInto1() {
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int dayToAdd = 1;
                    if (dow == DayOfWeek.FRIDAY)
                        dayToAdd = 3;
                    else if (dow == DayOfWeek.SATURDAY)
                        dayToAdd = 2;
                    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
                }
        );
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date3 = LocalDate.of(2014, 3, 18);
        String formatterDate = date3.format(formatter);
        LocalDate date4 = LocalDate.parse(formatterDate, formatter);
    }
}
