package top.yooonn.explore.java8.java.util;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.03.14
 */
public class ComparatorTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ComparatorTests.class);

    @Test
    public void mainTest() {

        // noinspection WrapperTypeMayBePrimitive
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        // noinspection ConstantConditions
        if (a == 6) {
            log.debug("watch point: {}", 22);
        }
        // noinspection ConstantConditions
        if (b == a) {
            log.debug("watch point: {}", 28);
        }
    }

    @Test
    public void main2Test() {

        class X {

            Integer x;

            public X(Integer x) {
                this.x = x;
            }
        }

        X x = new X(-129);
        Integer a = -129;

        if (x.x == a) {
            log.debug("watch point: {}", 36);
        }
    }

    enum A {

        a(-129),
        b(2),
        ;

        private Integer code;

        A(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }
}
