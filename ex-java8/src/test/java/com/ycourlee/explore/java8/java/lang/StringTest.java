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
}
