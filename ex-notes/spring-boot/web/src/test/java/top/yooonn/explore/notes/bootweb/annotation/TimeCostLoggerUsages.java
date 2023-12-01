package top.yooonn.explore.notes.bootweb.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;

/**
 * @author yooonn
 * @date 2022.03.23
 */
public class TimeCostLoggerUsages {

    private static final Logger log = LoggerFactory.getLogger(TimeCostLoggerUsages.class);

    @TimeCostLogger(logLevel = LogLevel.ERROR)
    public void plainUsage() {
        log.warn("watch point: {}", 13);
    }
}
