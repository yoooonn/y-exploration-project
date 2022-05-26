package com.ycourlee.explore.java8.java.util.regex;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author yooonn
 * @date 2021.09.09
 */
public class MainTest {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void mainTest() {
        String[] split = "123，345 678,890".split("[ ]|[,]|[，]");
        Assertions.assertThat(split).extracting("length").isEqualTo(4);

        log.info("split: {}", Arrays.toString(split));
    }
}
