package top.yooonn.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2021.08.24
 */
public class DoubleTest {

    private static final Logger log = LoggerFactory.getLogger(DoubleTest.class);

    @Test
    public void doubleToLongBitsTest() {
        double n = 10000000000.2;
        log.info("n: {}", n);
        log.info("Double.doubleToLongBits(n) = {}", Double.doubleToLongBits(n));
        log.info("Double.doubleToRawLongBits(n) = {}", Double.doubleToRawLongBits(n));
    }
}
