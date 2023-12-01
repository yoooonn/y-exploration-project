package top.yooonn.explore.java8.other;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.05.02
 */
public class LoopTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(LoopTests.class);

    @Test
    public void mainTest() {
        // 0: 0,0
        // 1: 0,3
        // 2: 0,6
        // 3: 3,0
        // 4: 3,3
        // 5: 3,6
        // 6: 6,0
        // 7: 6,3
        // 8: 6,6
        for (int index = 0; index < 9; index++) {
            int i = (index / 3) * 3;
            int j = (index % 3) * 3;
            log.info("{}", '\n');
            for (int k = i; k < i + 3; k++) {
                for (int l = j; l < j + 3; l++) {
                    log.info("{}, {} index: {}", k, l, indexOfBox(k, l));
                }
            }
        }
    }

    public int indexOfBox(int i, int j) {
        int a = (i / 3) * 3;
        int b = (j / 3) * 3;
        return (a / 3) * 3 + b / 3 + 1;
    }

    @Test
    public void main2Test() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                log.info("{}, {}, ", i + 1, j + 1);
            }
        }
    }
}
