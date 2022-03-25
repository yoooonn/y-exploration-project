package com.ycourlee.explore.bootprocess.inject;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yongjiang
 * @date 2022.02.18
 */
public class InjectValuePortalTest extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(InjectValuePortalTest.class);

    @Autowired
    private InjectValuePortal injectValuePortal;

    @Test
    public void mainTest() {
        Integer integer = injectValuePortal.getTwoRouteLongestTime().get(88L);

        log.info("integer: {}", integer);
    }
}
