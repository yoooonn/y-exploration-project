package com.ycourlee.explore.notes.springredission.other;

import com.ycourlee.explore.notes.springredission.RedissionSpringApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.04.02
 */
public class GetMultiLockTests extends RedissionSpringApplicationTests {

    private CountDownLatch latch = new CountDownLatch(2);

    @Test
    void main2Test() {
        RLock multiLock = getMultiLock("hello", "world");

    }

    @Test
    void mainTest() throws InterruptedException {
        new Thread(() -> {
            RLock multiLock = getMultiLock("hello", "world");
            try {
                if (multiLock.tryLock(2, 5, TimeUnit.SECONDS)) {
                    TimeUnit.SECONDS.sleep(4);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                multiLock.unlock();
            }
            latch.countDown();
        }).start();
        new Thread(() -> {
            RLock multiLock = getMultiLock("hello", "world");
            try {
                if (multiLock.tryLock(2, 5, TimeUnit.SECONDS)) {
                    TimeUnit.SECONDS.sleep(4);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (multiLock.isLocked()) {
                    multiLock.unlock();
                }
            }
            latch.countDown();
        }).start();
        latch.await();
    }
}
