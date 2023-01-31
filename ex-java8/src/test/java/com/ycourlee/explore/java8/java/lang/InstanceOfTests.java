package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author yooonn
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
        Object ints = Arrays.asList(1, 2, 3);
        // noinspection ConstantConditions
        assertTrue(ints instanceof List);
        assertTrue(ints instanceof AbstractCollection);
        assertTrue(ints instanceof AbstractList);
        assertFalse(ints instanceof ArrayList);
    }

    @Test
    public void primaryTest() {

        Object a = new BB();
        Object aa = new CC();
        assertTrue(a instanceof A);
        assertTrue(a instanceof B);
        assertTrue(aa instanceof C);
        assertTrue(aa instanceof A);
    }

    interface A {}
    interface B extends A {}
    interface C extends B {}
    static class BB implements B {}
    static class CC extends BB implements C {}
}
