package com.ycourlee.explore.java8.java.util.stream;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yooonn
 * @date 2022.03.29
 */
public class StreamTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(StreamTests.class);

    @Test
    public void mainTest() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4);

        boolean match = data.stream().allMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                boolean b = integer % 2 == 0;
                log.info("integer: {}", integer);
                return b;
            }
        });

        log.info("match: {}", match);
    }
}
