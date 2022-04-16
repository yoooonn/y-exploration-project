package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author yongjiang
 * @date 2022.04.12
 */
public class InstanceOfTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(InstanceOfTests.class);

    @Test
    public void main2Test() {
        // noinspection MismatchedQueryAndUpdateOfCollection
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
        // noinspection ConstantConditions
        assertTrue(ints instanceof ArrayList);
        // noinspection ConstantConditions
        assertTrue(ints instanceof List);
    }

    @Test
    public void mainTest() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        // noinspection ConstantConditions
        assertTrue(ints instanceof List);
        assertTrue(ints instanceof AbstractList);
        assertFalse(ints instanceof ArrayList);
    }
}
