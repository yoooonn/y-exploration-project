package com.ycourlee.explore.java8.java.io;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author yongjiang
 * @date 2021.09.19
 */
public class MainTest {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void mainTest() {
        List<String> es = Lists.newArrayList("a", "b", "c");
        for (String e : es) {
            if (e.equals("b")) {
                es.remove(e);
            }
        }
        log.info("es: {}", es);
    }

    private void fn(List<String> strings) {

    }
}
