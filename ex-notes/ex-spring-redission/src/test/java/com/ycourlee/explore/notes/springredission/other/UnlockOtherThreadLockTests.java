package com.ycourlee.explore.notes.springredission.other;

import com.ycourlee.explore.notes.springredission.RedissionSpringApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2022.04.07
 */
public class UnlockOtherThreadLockTests extends RedissionSpringApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(UnlockOtherThreadLockTests.class);

    @Test
    void main3Test() {
        log.info("System.nanoTime(): {}", System.nanoTime());
        log.info("Duration.ofDays(1).getSeconds(): {}", Duration.ofDays(1).toNanos());
    }

    @Test
    void mainTest() throws InterruptedException {
        RLock lock = getLock("this:is:a:lock");

        try {

            lock.tryLock(5, 1000, TimeUnit.SECONDS);
            TimeUnit.MINUTES.sleep(100);
        } finally {
            lock.unlock();
        }
    }

    @Test
    void main2Test() {
        RLock lock = getLock("this:is:a:lock");
        lock.unlock();
    }
}
