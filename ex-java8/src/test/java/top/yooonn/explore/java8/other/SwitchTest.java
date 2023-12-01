package top.yooonn.explore.java8.other;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.04.24
 */
public class SwitchTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(SwitchTest.class);

    @Test
    public void mainTest() {
        int a = getA();

        switch (a) {
            case 3:
                log.debug("watch point: {}", 22);
                // return;
            case 4:
                log.debug("watch point: {}", 24);
            case 5:
                log.debug("watch point: {}", 24);
            default:

        }
    }

    private int getA() {
        return 4;
    }
}
