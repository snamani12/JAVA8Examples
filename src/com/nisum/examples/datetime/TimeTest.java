package com.nisum.examples.datetime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        ZoneId zoneId = ZoneId.of("America/Chicago");
        LocalTime localTime2 = LocalTime.now(zoneId);
        System.out.println(localTime2);

        LocalTime localTime3 = LocalTime.parse("10:30");
        System.out.println(localTime3);

        LocalTime localTime4 = LocalTime.of(10, 30);
        System.out.println(localTime4);

        LocalTime localTime5 = LocalTime.parse("10:30").plus(2, ChronoUnit.HOURS);
        System.out.println(localTime5);

        boolean before = LocalTime.parse("10:30").isBefore(LocalTime.parse("11:00"));
        System.out.println(before);



        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);
    }
}
