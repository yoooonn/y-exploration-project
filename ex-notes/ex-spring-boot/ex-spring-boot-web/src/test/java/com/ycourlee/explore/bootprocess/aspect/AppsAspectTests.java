package com.ycourlee.explore.notes.bootweb.aspect;

import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import com.ycourlee.explore.notes.bootweb.annotation.TimeCostLogger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yongjiang
 * @date 2022.03.23
 */
@TestPropertySource(properties = {
        "logging.level.com.ycourlee.explore.notes.bootweb.aspect.AppsAspectTests=debug",
        "logging.level.com.ycourlee.explore.notes.bootweb.aspect.AppsAspect=trace"
})
public class AppsAspectTests extends BootProcessApplicationTests {

    @Autowired
    private TimeCostLoggerUsage timeCostLoggerUsage;

    @Test
    public void mainTest() {
        assertTrue(timeCostLoggerUsage.plainUsage());
    }

    @Component
    static class TimeCostLoggerUsage {

        private static final Logger log = LoggerFactory.getLogger(TimeCostLoggerUsage.class);

        @TimeCostLogger
        public boolean plainUsage() {
            log.debug("watch point: {}", 13);
            return true;
        }
    }
}
