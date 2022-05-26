package com.ycourlee.explore.java8.java.util.concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yooonn
 * @date 2022.01.04
 */
public class ConcurrentHashMapTest {

    private static final Logger log = LoggerFactory.getLogger(ConcurrentHashMapTest.class);

    @Test
    public void mainTest() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

        map.put("e21", new Object());
        map.put("e22", new Object());
        map.put("e23", new Object());
        map.put("e24", new Object());
        map.put("e25", new Object());
        map.put("e26", new Object());
        map.put("e27", new Object());
        map.put("e28", new Object());
        map.put("e29", new Object());
        map.put("e30", new Object());
        map.put("e31", new Object());
        map.put("e32", new Object());
        map.put("e33", new Object());
        map.put("e34", new Object());
        map.put("e35", new Object());
        map.put("e36", new Object());
        map.put("e37", new Object());
        map.put("e38", new Object());
    }

    @Test
    public void o1Test() {
        log.info("1<<3: {}", 1 << 3);
        log.info("Integer.toBinaryString(1): {}", Integer.toBinaryString(1));
        log.info("Integer.toBinaryString(1<<3): {}", Integer.toBinaryString(1 << 3));

        log.info("Integer.toBinaryString(-8): {}", Integer.toBinaryString(-8));
        log.info("-8>>>3: {}", -8 >>> 3);
        log.info(Integer.toBinaryString(-8 >>> 3));

        log.info("-8>>3: {}", -8 >> 3);
        log.info(Integer.toBinaryString(-8 >> 3));

        log.info("Integer.toBinaryString(1000): {}", Integer.toBinaryString(1000));
        log.info("1000>>>3: {}", 1000 >>> 3);
        log.info("Integer.toBinaryString(1000>>>3): {}", Integer.toBinaryString(1000 >>> 3));
    }

    @Test
    public void o2Test() {
        log.info("Integer.toBinaryString(13): {}", Integer.toBinaryString(13));
        log.info("Integer.toBinaryString(3): {}", Integer.toBinaryString(3));
        log.info("13^3: {}", 13 ^ 3);
    }
}
