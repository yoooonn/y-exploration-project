package com.ycourlee.explore.javalib.org.slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2021.12.27
 */
public class LoggerTest {

    private static final Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    void mainTest() {
        if (log.isDebugEnabled()) {

        }
        log.debug("hello {}", "world", new RuntimeException());
    }
}
