package com.kanghai.java8.chapter12;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/15 23:48
 * @description
 */

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);
//        int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
    }

    private void test1(LocalDate date){
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();

        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(2014,Month.APRIL, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = time.atDate(date);
        LocalDateTime dt5 = date.atTime(time);
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }

    private void test2(LocalDate date){
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
    }
}
