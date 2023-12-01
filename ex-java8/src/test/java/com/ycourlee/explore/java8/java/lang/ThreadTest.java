package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.tranquil.core.CommonConstants;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author yooonn
 */
public class ThreadTest extends CommonConstants {

    private static final Logger log = LoggerFactory.getLogger(ThreadTest.class);
    int shared_testWaitAndNotify = 1;

    @Test
    public void testWaitAndNotify() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(null, () -> {
            latch.countDown();
            while (true) {
                try {
                    log.info("{} wait", Thread.currentThread().getName());
                    Thread.currentThread().wait();
                    log.info("{} got notify", Thread.currentThread().getName());
                    shared_testWaitAndNotify++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t-wait");
        Thread t2 = new Thread(null, () -> {
            latch.countDown();
            while (true) {
                log.info("notify {}", t1.getName());
                t1.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shared_testWaitAndNotify++;
            }
        }, "t-notify");

        t1.start();
        t2.start();

        latch.await();
    }
}
