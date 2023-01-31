package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yooonn
 * @date 2022.01.10
 */
public class BooleanTest {

    private static final Logger log = LoggerFactory.getLogger(BooleanTest.class);

    @Test
    public void xorTest() {
        boolean a = false;
        boolean b = true;
        assertThat(a ^ b).isTrue();
        a = false;
        b = false;
        assertThat(a ^ b).isFalse();
        a = true;
        b = true;
        assertThat(a ^ b).isFalse();
    }

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
