package com.ycourlee.explore.java8.java.time;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author yongjiang
 * @date 2022.02.14
 */
public class LocalDateTimeTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(LocalDateTimeTest.class);

    @Test
    public void mainTest() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2022, 1, 14), LocalTime.of(16, 30));
        log.info("localDateTime: {}", localDateTime);
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        LocalDateTime localDateTime2 = localDateTime.plusDays(2);
        log.info("localDateTime1: {}", localDateTime1);
        log.info("localDateTime2: {}", localDateTime2);
        log.info("localDateTime: {}", localDateTime);
    }

    @Test
    public void main2Test() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2022, 1, 14), LocalTime.of(16, 30));
        LocalDateTime localDateTime1 = localDateTime.withHour(18).withSecond(14);
        LocalDateTime localDateTime2 = localDateTime.withHour(19).withSecond(22);
        log.info("localDateTime1: {}", localDateTime1);
        log.info("localDateTime2: {}", localDateTime2);
        log.info("localDateTime: {}", localDateTime);
    }
}
