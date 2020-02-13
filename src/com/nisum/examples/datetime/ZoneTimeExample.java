package com.nisum.examples.datetime;

import java.sql.Timestamp;
import java.time.*;

public class ZoneTimeExample {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Local ZonedDateTime :: "+zonedDateTime);

        ZoneId zoneId = ZoneId.of("Asia/Kolkata");

//		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
//		availableZoneIds.forEach( System.out::println);
//		System.out.print(availableZoneIds);

        OffsetDateTime offsetTime = OffsetDateTime.now();
        System.out.println("Offset Date Time :: " + offsetTime);

        Instant in = Instant.now();
        System.out.println("Instant date time :: " + in);
        System.out.println("Legacy TimeStamp :: " + new Timestamp(System.currentTimeMillis()));

        Timestamp timestamp = Timestamp.from(in);
        System.out.println("Convert from Instant to TimeStamp :: " + timestamp);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        System.out.println("Local ZonedDateTime by using Factor of method :: "+zonedDateTime2);
        System.out.println("Local Zone Id :: "+zonedDateTime.getOffset());
    }
}
