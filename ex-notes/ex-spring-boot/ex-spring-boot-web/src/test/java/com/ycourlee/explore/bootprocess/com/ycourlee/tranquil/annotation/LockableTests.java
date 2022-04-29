package com.ycourlee.explore.notes.bootweb.com.ycourlee.tranquil.annotation;

import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author yongjiang
 * @date 2022.04.16
 */
@TestPropertySource(properties = {
        "logging.level.com.ycourlee.tranquil.autoconfiguration.redisson.LockableAspect=warn"
})
public class LockableTests extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LockableTests.class);

    @Autowired
    private LockableUsages lockableUsages;

    private CountDownLatch latch;

    @Test
    public void multiLockTest() throws InterruptedException {
        // for (int j = 0; j < 10; j++) {
        int threadCnt = 100;
        Long sharedNumber = lockableUsages.sharedNumberToZero();
        CountDownLatch localLatch = new CountDownLatch(threadCnt * 3);
        for (int i = 0; i < threadCnt; i++) {
            new Thread(() -> {
                lockableUsages.incrementSharedNumberInLock();
                localLatch.countDown();
            }).start();
            new Thread(() -> {
                lockableUsages.incrementSharedNumber1InLock();
                localLatch.countDown();
            }).start();
            new Thread(() -> {
                lockableUsages.incrementTwoSharedNumberInLock();
                localLatch.countDown();
            }).start();
        }
        localLatch.await();
        log.info("lockableUsages.sharedNumber(): {}", lockableUsages.sharedNumber());
        // }
    }

    /**
     * 200线程对同一操作数进行加1操作，循环10次，使用不同的同步方式，总耗时如下<br />
     * <p/>
     *
     * <tb>
     * <tr>
     * <th>同步方式</th>
     * <th>耗时（ms/per 200T）</th>
     * </tr>
     * <tr>
     * <td>无锁</td>
     * <td>22.6</td>
     * </tr>
     * <tr>
     * <td>synchronized method</td>
     * <td>23.9</td>
     * </tr>
     * <tr>
     * <td>lockable annotation</td>
     * <td>842.8</td>
     * </tr>
     * <tr>
     * <td>set nx</td>
     * <td>1911.1</td>
     * </tr>
     * </tb>
     *
     * @throws InterruptedException
     */
    @Test
    public void main4Test() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int j = 0; j < 10; j++) {
            int threadCnt = 200;
            Long sharedNumber = lockableUsages.sharedNumberToZero();
            CountDownLatch localLatch = new CountDownLatch(threadCnt);
            for (int i = 0; i < threadCnt; i++) {
                new Thread(() -> {
                    lockableUsages.incrementSharedNumberInLock();
                    localLatch.countDown();
                }).start();
            }
            localLatch.await();
            log.info("lockableUsages.sharedNumber(): {}", lockableUsages.sharedNumber());
        }
        stopWatch.stop();
        log.info("stopWatch: {}", stopWatch.getTotalTimeMillis());
    }

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
