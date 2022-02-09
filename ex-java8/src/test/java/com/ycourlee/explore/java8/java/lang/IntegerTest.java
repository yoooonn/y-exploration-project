package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2021.09.28
 */
public class IntegerTest {

    private static final Logger log = LoggerFactory.getLogger(IntegerTest.class);

    @Test
    public void main2Test() {
        System.out.println("48,60,64,79,83,104,119,127,132,133,143,145,155,166,193,199,209,214,217,225,227,229,269,279,284,293,306,324,326,329,340,360,362,372,376,384,398,404,415,428,457,459,468,473,476,496,499,501,509,515,533,535,539,545,554,560,564,571,574,581,602,605,610,613,625,687,743,745,752,767,772,773,786,803,805,813,827,857,863,887".split(",").length);
    }

    @Test
    public void draftTest() {
        List<String> strings = Arrays.asList("23",
                "06",
                "11",
                "49",
                "04",
                "22",
                "02",
                "59",
                "11",
                "23",
                "17",
                "36",
                "52",
                "56",
                "18",
                "32",
                "12",
                "44",
                "22",
                "10",
                "54",
                "03",
                "06",
                "50",
                "29",
                "06",
                "48",
                "10",
                "51",
                "45",
                "25",
                "07",
                "29",
                "10",
                "20",
                "40",
                "18",
                "09",
                "19",
                "48",
                "46",
                "10",
                "12",
                "34",
                "36",
                "52",
                "42",
                "32",
                "16",
                "18",
                "17",
                "14",
                "49",
                "07",
                "13",
                "09",
                "59",
                "48",
                "37",
                "14",
                "28",
                "30",
                "07",
                "07",
                "24",
                "41",
                "34");
        List<String> collect = strings.stream().map(s -> {
            int i = Integer.parseInt(s);
            i--;
            if (i < 9) {
                return "0" + i;
            } else {
                return i + "";
            }
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    @Test
    public void equalsJudgingTest() {
        Integer a = boxing(2);
        log.info("a == b: {}", a == boxing(2));
    }

    private Integer boxing(int x) {
        return x;
    }

    @Test
    public void mainTest() {
        System.out.println("check(1) = " + check(null));
    }

    private boolean check(Integer a) {
        Integer b = 1;
        return a == b;
    }
}
