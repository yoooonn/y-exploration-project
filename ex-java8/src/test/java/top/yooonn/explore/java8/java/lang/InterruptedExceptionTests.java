package top.yooonn.explore.java8.java.lang;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.04.04
 */
public class InterruptedExceptionTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(InterruptedExceptionTests.class);

    @Test
    public void mainTest() {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            log.debug("watch point: {}", 26);
        }
    }
}
