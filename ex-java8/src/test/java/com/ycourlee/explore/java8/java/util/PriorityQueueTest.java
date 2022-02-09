package com.ycourlee.explore.java8.java.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yongjiang
 * @date 2022.01.05
 */
public class PriorityQueueTest {

    private static final Logger log = LoggerFactory.getLogger(PriorityQueueTest.class);

    @Test
    public void mainTest() {
        PriorityQueue<Cat> queue = new PriorityQueue<>(Comparator.comparingInt(Cat::getSort));
        queue.add(new Cat(5, "5"));
        queue.add(new Cat(6, "6"));
        queue.add(new Cat(1, "1"));

        while (queue.size() > 0) {
            Cat poll = queue.poll();
            log.info("{}: {}", poll.getSort(), poll.getName());
        }
    }
}
