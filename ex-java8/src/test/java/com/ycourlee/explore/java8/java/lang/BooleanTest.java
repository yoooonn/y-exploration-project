package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2022.01.10
 */
public class BooleanTest {

    private static final Logger log = LoggerFactory.getLogger(BooleanTest.class);

    @Test
    public void mainTest() {
        Boolean flag;
        if (flag = judge(5)) {
            log.info("flag: {}", flag);
        }
        if (flag) {
            log.info("flag: {}", flag);
        }
    }

    private boolean judge(int n) {
        return n % 2 == 1;
    }
}
