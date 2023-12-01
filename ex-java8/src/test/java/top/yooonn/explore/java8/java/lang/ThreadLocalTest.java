package top.yooonn.explore.java8.java.lang;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * @author yooonn
 * @date 2023.02.10
 */
public class ThreadLocalTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ThreadLocalTest.class);

    @Test
    public void testRemove() throws InterruptedException {
        ThreadLocal<Integer> cnt = new ThreadLocal<>();
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    cnt.set(Optional.ofNullable(cnt.get()).orElse(0) + 1);
                    log.info("{} {}", Thread.currentThread().getName(), cnt.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
    }
}
