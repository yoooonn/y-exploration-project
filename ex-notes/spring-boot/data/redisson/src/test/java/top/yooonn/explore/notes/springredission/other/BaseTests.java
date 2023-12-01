package top.yooonn.explore.notes.springredission.other;

import top.yooonn.explore.notes.springredission.RedissionSpringApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.04.14
 */
public class BaseTests extends RedissionSpringApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(BaseTests.class);

    @Test
    void onlyTryLockTest() throws InterruptedException {
        RLock foo = getLock("foo");
        boolean lock = foo.tryLock(5, 60, TimeUnit.SECONDS);
        log.info("lock: {}", lock);
    }

    @Test
    void onlyUnlockTest() throws InterruptedException {
        RLock foo = getLock("foo");
        foo.unlock();
    }
}
