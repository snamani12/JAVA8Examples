package com.nisum.examples.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodAndDurationExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate date2 = LocalDate.parse("2020-01-02");
        System.out.println(date.plus(Period.ofDays(5)));

        Period period = Period.between(date2, date);
        System.out.println("Period: " + period);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        Duration duration = Duration.ofHours(2);
        System.out.println(localTime.plusSeconds(duration.getSeconds()));
    }
}
