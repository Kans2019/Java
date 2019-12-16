package com.kanghai.java8.chapter12;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/17 0:47
 * @description
 */

public class ZoneIdTest {
    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

    }
}
