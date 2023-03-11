package com.ycourlee.explore.java8.java.util.concurrent;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yooonn
 * @date 2023.02.27
 */
public class CopyOnWriteArrayListTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(CopyOnWriteArrayListTest.class);

    @Test
    public void mainTest() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.forEach(i -> log.info("{}", i));
    }


}
