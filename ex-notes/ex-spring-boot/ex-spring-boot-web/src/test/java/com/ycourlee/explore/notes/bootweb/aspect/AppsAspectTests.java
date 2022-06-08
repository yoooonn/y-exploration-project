package com.ycourlee.explore.notes.bootweb.aspect;

import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import com.ycourlee.explore.notes.bootweb.annotation.TimeCostLoggerUsages;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yooonn
 * @date 2022.03.23
 */
@TestPropertySource(properties = {
        "logging.level.com.ycourlee.explore.notes.bootweb.aspect.AppsAspectTests=debug",
        "logging.level.com.ycourlee.explore.notes.bootweb.aspect.AppsAspect=trace"
})
public class AppsAspectTests extends BootProcessApplicationTests {

    @Autowired
    private TimeCostLoggerUsages timeCostLoggerTests;

    @Test
    public void mainTest() {
        timeCostLoggerTests.plainUsage();
    }
}
