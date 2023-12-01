package top.yooonn.explore.notes.bootweb.org.springframework.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @author yooonn
 * @date 2022.06.22
 */
public class StopWatchTests {

    private static final Logger log = LoggerFactory.getLogger(StopWatchTests.class);

    @Test
    void mainTest() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();
        log.info("totalTimeSeconds: {}", totalTimeSeconds);
    }
}
