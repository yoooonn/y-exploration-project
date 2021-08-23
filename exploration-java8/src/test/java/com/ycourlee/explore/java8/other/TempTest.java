package com.ycourlee.explore.java8.other;

import org.junit.Test;

/**
 * @author yongjiang
 * @date 2021.08.04
 */
public class TempTest {

    @Test
    public void temp1Test() {
        System.out.println("1048576/1024 = " + 1048576 / 1024);
    }

    @Test
    public void temp2Test() {
        Integer a = 5;
        add(a);
        System.out.println("a = " + a);
    }

    private void add(Integer a) {
        a = a + 1;
    }
}
