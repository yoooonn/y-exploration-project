package com.ycourlee.explore.bootprocess.com.ycourlee.tranquil.annotation;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author yongjiang
 * @date 2022.04.16
 */
public class LockableTests extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LockableTests.class);

    @Autowired
    private LockableUsages lockableUsages;

    private CountDownLatch latch;

    @Test
    public void main3Test() {
        // for (int i = 0; i < 10; i++) {
        latch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                lockableUsages.simple("lock2");
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(() -> {
            try {
                lockableUsages.withPattern("hello");
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(() -> {
            try {
                lockableUsages.multiLock("hello");
            } catch (Exception e) {
                log.warn("{}", e.getMessage());
            } finally {
                latch.countDown();
            }
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            // log.error("", e);
        }
        // }
    }

    @Test
    public void main2Test() {
        new Thread(() -> {
            lockableUsages.withPattern("world");
            latch.countDown();
        }).start();
        new Thread(() -> {
            lockableUsages.withPattern("world");
            latch.countDown();
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mainTest() {
        new Thread(() -> {
            lockableUsages.simple();
            latch.countDown();
        }).start();
        new Thread(() -> {
            lockableUsages.simple();
            latch.countDown();
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
