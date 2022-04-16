package com.ycourlee.explore.bootprocess.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2022.03.23
 */
@Component
public class TimeCostLoggerTests {

    private static final Logger log = LoggerFactory.getLogger(TimeCostLoggerTests.class);

    @TimeCostLogger(logLevel = LogLevel.ERROR)
    public void plainUsage() {
        log.warn("watch point: {}", 13);
    }
}
