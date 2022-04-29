package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2022.02.09
 */
public class StringTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void appendTest() {
        Integer a = null;
        Integer b = null;
        String s = a + "-" + b;
        log.info("s: {}", s);
        log.info("a: {}", a);
    }

    @Test
    public void split2Test() {
        String[] split = "48,62,64,79,83,104,119,127,132,133,143,145,155,164,166,170,193,199,209,213,214,217,225,227,229,269,279,284,287,293,295,306,324,326,329,340,360,362,372,376,384,398,404,415,428,457,459,468,473,476,496,499,501,509,515,531,533,535,539,545,554,560,564,571,574,581,602,605,610,613,625,635,687,743,745,752,767,772,773,786,803,805,813,827,837,857,863,887,895".split(",");
        String s = "326,602,605,606,610,613,621,625,635,658,659,662,666,675,676,680,687,734,740,743,745,749";
        String[] split1 = s.split(",");
        String s2 = "415";
        String s3 = "752,759,767,772,773,779,786,803,805,813,827,857,863,887,895";

        String s4 = "404,411,413,428,429,439,444,455,457,459,463,466,467,468,473,476,478,480,492,496,499,501,503,509,510,512,515,528,531,533,535,536,539,545,554,560,566,571,574,581,588,596";
        String s5 = "209,213,214,225,227,229,269,279,284,287,293,295,306,324,329,340,360,362,372,376,384,398";
        String s6 = "48,62,64,79,83,104,119,127,132,133,143,145,155,164,166,193,199";
        String[] split3 = s3.split(",");
        String[] split4 = s4.split(",");
        String[] split5 = s5.split(",");
        String[] split6 = s6.split(",");

        List<String> strings = Arrays.asList(split1);
        List<String> strings3 = Arrays.asList(split3);
        List<String> strings4 = Arrays.asList(split4);
        List<String> strings5 = Arrays.asList(split5);
        List<String> strings6 = Arrays.asList(split6);

        Arrays.stream(split).filter(ss -> {
            return !strings.contains(ss) &&
                    !strings3.contains(ss) &&
                    !strings4.contains(ss) &&
                    !strings5.contains(ss) &&
                    !strings5.equals("415") &&
                    !strings6.contains(ss);
        }).forEach(System.out::println);

    }

    @Test
    public void splitTest() {
        String[] split = "55, 6, 7".split(",");
        List<Integer> collect = Arrays.stream(split).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        log.info("collect: {}", collect);
    }

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
