package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2021.09.28
 */
public class IntegerTest {

    private static final Logger log = LoggerFactory.getLogger(IntegerTest.class);

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
