package top.yooonn.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author yooonn
 * @date 2022.04.06
 */
public class XorOperationTests {

    private static final Logger log = LoggerFactory.getLogger(XorOperationTests.class);

    @Test
    public void main2Test() {
        log.info(String.valueOf(5 ^ 5));
        List<Integer> ans = new ArrayList<>();

    }

    @Test
    public void mainTest() {
        log.info(String.valueOf(xorTwice(Arrays.asList(3, 9, 1, 1, 4, 5, 6, 7, 8))));
    }

    private int xorTwice(List<Integer> ints) {
        int res = ints.get(0) ^ ints.get(1);
        for (int i = 2; i < ints.size(); i++) {
            res ^= ints.get(i);
        }
        for (Integer anInt : ints) {
            res ^= anInt;
            if (res == 0) {
                return anInt;
            }
        }
        return res;
    }
}
