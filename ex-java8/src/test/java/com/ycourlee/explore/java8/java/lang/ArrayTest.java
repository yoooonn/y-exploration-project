package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author yongjiang
 * @date 2022.02.17
 */
public class ArrayTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ArrayTest.class);

    @Test
    public void main2Test() {
        print("nihao", "hello", "world");
        print("nihao","", "world");
        print();
    }

    private void print(String... args) {
        log.info("args.length: {}", args.length);
        for (String arg : args) {
            log.info(arg.toUpperCase());
        }
    }

    @Test
    public void mainTest() {
        Object[] objects = new Object[2];
        objects[0] = "hello";
        objects[1] = "world";
        log.info("objects: {}", Arrays.toString(objects));
    }
}
