package com.ycourlee.explore.java8.java.util.concurrent;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author yooonn
 * @date 2022.01.06
 */
public class ConcurrentLinkedQueueTest {

    Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    @Test
    public void mainTest() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
