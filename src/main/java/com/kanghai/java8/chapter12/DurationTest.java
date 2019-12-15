package com.kanghai.java8.chapter12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/16 0:13
 * @description
 */

public class DurationTest {

    public static void main(String[] args) {
     LocalDate date1 = LocalDate.of(2014, 3, 18);
     LocalDate date2 = date1.plusWeeks(1);
     LocalDate date3 = date2.minusYears(3);

    }


    private void test1(){

        LocalTime time1 = LocalTime.of(0, 15, 0);
        LocalTime time2 = LocalTime.of(0, 40, 0);
        Duration d1 = Duration.between(time1, time2);
        Instant instant1 = Instant.ofEpochSecond(1,1);
        Instant instant2 = Instant.ofEpochSecond(2, 3);
        Duration d2 = Duration.between(instant1, instant2);

        LocalDate date1 = LocalDate.of(2000,1,1);
        LocalDate date2= LocalDate.of(2020,1,1);

        System.out.println("1");
    }

    private void test2(){
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        System.out.println(1);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(1);

        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
    }
}
