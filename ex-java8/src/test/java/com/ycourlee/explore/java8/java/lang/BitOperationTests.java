package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 位运算
 *
 * @author yooonn
 * @date 2022.06.20
 */
public class BitOperationTests {

    private static final Logger log = LoggerFactory.getLogger(BitOperationTests.class);

    @Test
    public void mainTest() {
        int x = 32;
        log.info("x << 1: {}", x << 1);
        log.info("x << 1 | 1: {}", x << 1 | 1);
        log.info("x: {}", x);
    }
}
