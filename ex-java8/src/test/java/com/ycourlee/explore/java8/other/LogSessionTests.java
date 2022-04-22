package com.ycourlee.explore.java8.other;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author yooonn
 * @date 2022.04.22
 */
public class LogSessionTests extends AbstractTest {

    private CountDownLatch latch = new CountDownLatch(2);
    private static final Logger log = LoggerFactory.getLogger(LogSessionTests.class);

    @Test
    public void mainTest() throws InterruptedException {
        new Thread(() -> {
            MDC.put("session_id", UUID.randomUUID().toString());
            for (int i = 0; i < 10; i++) {
                log.info("{} {}",Thread.currentThread().getName(), i);
            }
            MDC.remove("session_id");
            latch.countDown();
        }).start();
        new Thread(() -> {
            MDC.put("session_id", UUID.randomUUID().toString());
            for (int i = 0; i < 10; i++) {
                log.info("{} {}",Thread.currentThread().getName(), i);
            }
            MDC.remove("session_id");
            latch.countDown();
        }).start();
        new Thread(() -> {
            MDC.put("session_id", UUID.randomUUID().toString());
            for (int i = 0; i < 10; i++) {
                log.info("{} {}",Thread.currentThread().getName(), i);
            }
            MDC.remove("session_id");
            latch.countDown();
        }).start();
        latch.await();
    }
}
