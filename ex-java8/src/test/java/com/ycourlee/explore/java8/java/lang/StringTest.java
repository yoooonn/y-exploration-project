package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2022.02.09
 */
public class StringTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void formatTest() {
        log.info("String.format(\"%12s\", \"nihao\"): {}", String.format("%12s", "nihao"));
    }

    @Test
    public void format2Test() {
        String temp = null;
        log.info("temp: {}", temp);
        log.info("String.format(\"asd %s %s asf\", null): {}", String.format("asd %s %s asf", null, "1234"));
    }

    @Test
    public void main4Test() {
        Object code = "40";
        String format = String.format("%5s", code).replaceAll(" ", "0");

        System.out.println("String.format(\"%s%s\", \"0\", \"12\") = " + String.format("%s%s", "0", "12"));

        System.out.println("format = " + format);
    }

    @Test
    public void mainTest() {
        String arg = String.valueOf(-1);
        log.info("String.valueOf(-1): {}", arg);

        String q23 = String.format("nihao:%s:%s", "q23", "*");
        log.info("q23: {}", q23);
    }
}
