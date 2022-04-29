package com.ycourlee.explore.notes.springredission.other;

import com.ycourlee.explore.notes.springredission.RedissionSpringApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * redissonClient.getLock(lockName)获取的是一把可重入锁
 *
 * @author jiangyong
 */
public class GetLockTests extends RedissionSpringApplicationTests {

    private static final Logger         log   = LoggerFactory.getLogger(GetLockTests.class);
    private              CountDownLatch count = new CountDownLatch(2);

    @Test
    void main4Test() {
        String lockName = "hello-test";
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 尝试获取锁", threadName);
            Pair<RLock, Boolean> lock = tryLock(lockName, 20L, 30, TimeUnit.SECONDS);
            if (lock.getSecond()) {
                log.info("线程：{} 尝试获取锁成功", threadName);
                log.info("线程：{} sleep...", threadName);
                for (int i = 0; i < 40; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        log.info("线程：{} slept {}s", threadName, i + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("线程：{} sleep结束", threadName);
                log.info("线程：{} 尝试释放锁", threadName);
                lock.getFirst().unlock();
                log.info("线程：{} 尝试释放锁成功", threadName);
            } else {
                log.info("线程：{} 未拿到锁，结束。。。", threadName);
            }
            count.countDown();
        }).start();
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 尝试获取锁", threadName);
            Pair<RLock, Boolean> lock = tryLock(lockName, 20L, 30, TimeUnit.SECONDS);
            if (lock.getSecond()) {
                log.info("线程：{} 尝试获取锁成功", threadName);
                log.info("线程：{} sleep...", threadName);
                for (int i = 0; i < 40; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        log.info("线程：{} slept {}s", threadName, i + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("线程：{} sleep结束", threadName);
                log.info("线程：{} 尝试释放锁", threadName);
                lock.getFirst().unlock();
                log.info("线程：{} 尝试释放锁成功", threadName);
            } else {
                log.info("线程：{} 未拿到锁，结束。。。", threadName);
            }
            count.countDown();
        }).start();
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("子线程都已执行完毕，main函数可以结束了！");
    }

    @Test
    void main3Test() {
        Pair<RLock, Boolean> tryLock = tryLock("this:is:a:key", 10, -1, TimeUnit.SECONDS);
        if (tryLock.getSecond()) {
            try {
                log.debug("acquire lock success.");
            } finally {
                tryLock.getFirst().unlock();
            }
        }
    }

    @Test
    void main2Test() {
        String lockName = "hello-test";
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 正在尝试获取锁。。。", threadName);
            Pair<RLock, Boolean> lock = tryLock(lockName, 40L, TimeUnit.SECONDS);
            doSomething(lock, lockName, threadName);
        }).start();
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("线程：{} 正在尝试获取锁。。。", threadName);
            Pair<RLock, Boolean> lock = tryLock(lockName, 40L, TimeUnit.SECONDS);
            doSomething(lock, lockName, threadName);
        }).start();
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("子线程都已执行完毕，main函数可以结束了！");
    }

    private void doSomething(Pair<RLock, Boolean> lock, String lockName, String threadName) {
        try {
            if (lock.getSecond()) {
                log.info("线程：{}，获取到了锁", threadName);
                log.info("线程：{}，重入一次", threadName);
                Pair<RLock, Boolean> pair = null;
                try {
                    pair = tryLock(lockName, 6L, TimeUnit.SECONDS);
                    if (!pair.getSecond()) {
                        log.info("线程：{}，重入失败", threadName);
                    } else {
                        log.info("线程：{}，重入成功", threadName);
                    }
                } finally {
                    if (pair != null) {
                        pair.getFirst().unlock();
                        log.info("线程：{}，释放重入锁", threadName);
                    }
                }

                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                log.info("线程：{}，没有获取到锁，过了等待时长，结束等待", threadName);
            }
            count.countDown();
        } finally {
            lock.getFirst().unlock();
            log.info("线程：{}，释放了锁", threadName);
        }
    }

    @Test
    void mainTest() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock");
        lock.tryLock(1, 12, TimeUnit.MINUTES);

        redissonClient.getKeys().getKeys().forEach(log::info);
        // lock.unlock();
    }
}
