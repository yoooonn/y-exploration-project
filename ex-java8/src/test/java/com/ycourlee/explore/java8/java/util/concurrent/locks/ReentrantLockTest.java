package com.ycourlee.explore.java8.java.util.concurrent.locks;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yooonn
 * @date 2023.02.27
 */
public class ReentrantLockTest extends AbstractTest {


    @Test
    public void mainTest() {
        ReentrantLock lock = new ReentrantLock();
        if (lock.tryLock()) {

        }
    }
}
